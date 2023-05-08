package com.example.springjava.controller;


import com.example.springjava.exception.BadRequestException;
import com.example.springjava.model.AuthenciationDTO;
import com.example.springjava.model.UserDTO;
import com.example.springjava.payload.request.SignInPayload;
import com.example.springjava.payload.request.SignUpPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.payload.response.AuthResponse;
import com.example.springjava.security.JwtTokenProvider;
import com.example.springjava.security.model.UserDetail;
import com.example.springjava.security.model.UserPrincipal;
import com.example.springjava.security.service.CustomUserDetailServiceImpl;
import com.example.springjava.service.AuthenciationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/auth")
public class AuthenciationController {
    private final Logger logger = LogManager.getLogger(AuthenciationController.class);

    @Autowired
    AuthenciationService authenciationService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    CustomUserDetailServiceImpl customUserDetailService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @PostMapping(value = "/sign-up")
    public ResponseEntity<ApiResponse<AuthResponse>> signUpAccount(
            HttpServletRequest request,
            @RequestBody SignUpPayload authenciationPayload) {
        AuthenciationDTO authenciationDTO = authenciationPayload.getAuthenciationDTO();
        UserDTO userDTO = authenciationPayload.getUserDTO();

        if (authenciationDTO.getUsername().isEmpty() || authenciationDTO.getPassword().isEmpty()) {
            throw new BadRequestException(String.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.getReasonPhrase(), "Username or Password can not be empty", request.getServletPath());
        }

        if (userDTO.getIdCard().isEmpty()) {
            throw new BadRequestException(String.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.getReasonPhrase(), "CCCD can not be empty", request.getServletPath());
        }
        try {
            UserDetail userDetail = authenciationService.signUpAccount(userDTO, authenciationDTO);
            UserPrincipal userPrincipal = UserPrincipal.create(userDetail);
            Authentication authentication = new UsernamePasswordAuthenticationToken(userPrincipal, null,
                    userPrincipal.getAuthorities());
            return ResponseEntity.ok(new ApiResponse<>(true, 200, "success", jwtTokenProvider.createAuthResponse(authentication)));
        } catch (Exception e) {
            BadRequestException.logger.error("Error occurred", e);
            throw new BadRequestException(String.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.getReasonPhrase(), "Duplicate username or idCard", request.getServletPath());
        }
    }


    @PostMapping(value = "/sign-in")
    public ResponseEntity<ApiResponse<?>> signIn(@RequestBody SignInPayload request) throws AuthenticationException {
        try {
            return ResponseEntity.ok(authenciationService.signIn(request));
        } catch (Exception e) {
            throw e;
        }
    }
}
