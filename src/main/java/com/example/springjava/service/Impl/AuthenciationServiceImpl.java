package com.example.springjava.service.Impl;

import com.example.springjava.entity.AuthenciationEntity;
import com.example.springjava.entity.UserEntity;
import com.example.springjava.exception.BadRequestException;
import com.example.springjava.model.AuthenciationDTO;
import com.example.springjava.model.UserDTO;
import com.example.springjava.respository.AuthenciationRepository;
import com.example.springjava.respository.UserRepository;
import com.example.springjava.security.model.UserDetail;
import com.example.springjava.service.AuthenciationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

    @Override
    @Transactional
    public UserDetail signUpAccount(UserDTO userDTO, AuthenciationDTO authenciationDTO) {
        if (authenciationRepository.existsByUsername(authenciationDTO.getUsername())) {
            throw new BadRequestException(String.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.getReasonPhrase(), "Error: Username is already taken!", "/auth/sign-up");
        }

        if (userRepository.existsByIdCard(userDTO.getIdCard())) {
            throw new BadRequestException(String.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.getReasonPhrase(), "Error: IdCard is already taken!", "/auth/sign-up");
        }
        authenciationDTO.setPassword(passwordEncoder.encode(authenciationDTO.getPassword()));
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        AuthenciationEntity authenciationEntity = modelMapper.map(authenciationDTO, AuthenciationEntity.class);
        AuthenciationEntity authenciation = authenciationRepository.save(authenciationEntity);
        userEntity.setAuthenciationEntity(authenciation);
        userRepository.save(userEntity);

        return new UserDetail(
                authenciation.getUserId(),
                authenciation.getUsername(),
                authenciation.getPassword(),
                authenciation.getRole(),
                authenciation.getPhoneNumber(),
                authenciation.getEmail(),
                authenciation.getDeviceId()
        );
    }

    @Override
    public void signIn() {

    }


}
