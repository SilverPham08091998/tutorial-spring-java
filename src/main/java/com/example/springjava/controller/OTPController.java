package com.example.springjava.controller;


import com.example.springjava.exception.BadRequestException;
import com.example.springjava.payload.request.ResendOTPPayload;
import com.example.springjava.payload.request.VerifyOTPPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.service.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/otp")
public class OTPController {
    @Autowired
    OTPService otpService;

    @PostMapping(value = "/verify")
    public ResponseEntity<ApiResponse<?>> verifyOTP(@RequestBody VerifyOTPPayload payload, HttpServletRequest request) {
        if (payload.getOtp().isEmpty()) {
            throw new BadRequestException("OTP can not be empty");
        }
        try {
            return ResponseEntity.ok(otpService.verifyOTP(payload));
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping(value = "/resend")
    public ResponseEntity<ApiResponse<?>> resendOTP(@RequestBody ResendOTPPayload payload) {
        try {
            return ResponseEntity.ok(otpService.resendOTP(payload.getUsername()));
        } catch (Exception e) {
            throw e;
        }
    }
}
