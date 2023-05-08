package com.example.springjava.service;

import com.example.springjava.payload.request.VerifyOTPPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.payload.response.AuthResponse;

public interface OTPService {

    void generateOTP(String username, String phoneNumber, String email);

    ApiResponse<AuthResponse> verifyOTP(VerifyOTPPayload payload);

    ApiResponse<String> resendOTP(String username);
}
