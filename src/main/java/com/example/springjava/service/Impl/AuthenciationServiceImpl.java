package com.example.springjava.service.Impl;

import com.example.springjava.entity.AuthenciationEntity;
import com.example.springjava.entity.RoleEntity;
import com.example.springjava.entity.UserEntity;
import com.example.springjava.exception.BadRequestException;
import com.example.springjava.model.AuthenciationDTO;
import com.example.springjava.payload.request.SignInPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.respository.AuthenciationRepository;
import com.example.springjava.respository.JwtHistoryRepository;
import com.example.springjava.respository.RoleRepository;
import com.example.springjava.respository.UserRepository;
import com.example.springjava.security.JwtTokenProvider;
import com.example.springjava.security.model.UserDetail;
import com.example.springjava.service.AuthenciationService;
import com.example.springjava.service.OTPService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class AuthenciationServiceImpl implements AuthenciationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenciationRepository authenciationRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    JwtHistoryRepository jwtHistoryRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    OTPService otpService;

    @Override
    @Transactional
    public UserDetail signUpAccount(AuthenciationDTO authenciationDTO) {
        if (authenciationRepository.existsByUsername(authenciationDTO.getUsername())) {
            throw new BadRequestException(String.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.getReasonPhrase(), "Error: Username is already taken!", "/auth/sign-up");
        }
        if (!roleRepository.existsById(authenciationDTO.getRole())) {
            throw new BadRequestException(String.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.getReasonPhrase(), "Error: Role is not exist!", "/auth/sign-up");
        }
        Optional<RoleEntity> roleEntity = roleRepository.findById(authenciationDTO.getRole());
        authenciationDTO.setPassword(passwordEncoder.encode(authenciationDTO.getPassword()));
        UserEntity userEntity = new UserEntity();
        AuthenciationEntity authenciationEntity = modelMapper.map(authenciationDTO, AuthenciationEntity.class);
        authenciationEntity.setRoleEntity(roleEntity.orElse(null));
        authenciationEntity.setStatus("ACTIVE");
        AuthenciationEntity authenciation = authenciationRepository.save(authenciationEntity);
        userEntity.setAuthenciationEntity(authenciation);
        userRepository.save(userEntity);

        return new UserDetail(
                authenciation.getUserId(),
                authenciation.getUsername(),
                authenciation.getPassword(),
                authenciation.getRoleEntity().getRoleName(),
                authenciation.getDeviceId()
        );
    }

    @Override
    public ApiResponse<?> signIn(SignInPayload request) {
        AuthenciationEntity authenciation = authenciationRepository.findAuthenciationEntityByUsername(request.getUsername());
        if (authenciation != null && !authenciation.getDeviceId().equals(request.getDeviceId())) {
            otpService.generateOTP(request.getUsername(), authenciation.getUserEntity().getPhoneNumber(), authenciation.getUserEntity().getEmail());
            return new ApiResponse<>(true, 200, "success", "Thiết bị đang đăng nhập trên tài khoản khác vui lòng nhập mã OTP để xác thực thiết bị mới");
        } else {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ApiResponse<>(true, 200, "success", jwtTokenProvider.createAuthResponse(authentication));
        }
    }


}
