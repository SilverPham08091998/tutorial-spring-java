package com.example.springjava.service;

import com.example.springjava.model.AuthenciationDTO;
import com.example.springjava.payload.request.SignInPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.security.model.UserDetail;

public interface AuthenciationService {
    UserDetail signUpAccount( AuthenciationDTO authenciationDTO);

    ApiResponse<?> signIn(SignInPayload payload);
}
