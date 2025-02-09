package com.example.springjava.service.Impl;

import com.example.springjava.entity.AuthenciationEntity;
import com.example.springjava.entity.OTPEntity;
import com.example.springjava.exception.BadRequestException;
import com.example.springjava.payload.request.VerifyOTPPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.payload.response.AuthResponse;
import com.example.springjava.respository.AuthenciationRepository;
import com.example.springjava.respository.OTPRepository;
import com.example.springjava.security.JwtTokenProvider;
import com.example.springjava.service.OTPService;
import com.example.springjava.util.function.GenarateOTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OTPServiceImpl implements OTPService {
    private final long OTP_EXPIRATION_TIME = 300000;
    private final long OTP_RESEND_TIME = 90000;

    @Autowired
    OTPRepository otpRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    AuthenciationRepository authenciationRepository;

    @Override
    public void generateOTP(String username, String phoneNumber, String email) {
        OTPEntity otpEntity = new OTPEntity();
        String otp = GenarateOTP.generateOtp();
        Date now = new Date();
        otpEntity.setUsername(username);
        otpEntity.setCountWrongOTP(0);
        otpEntity.setMatching(false);
        otpEntity.setExpiredDate(new Date(now.getTime() + OTP_EXPIRATION_TIME));
        otpEntity.setResendDate(new Date(now.getTime() + OTP_RESEND_TIME));
        otpEntity.setOtp(otp);
        otpEntity.setPhoneNumber(phoneNumber);
        otpEntity.setEmail(email);
        otpEntity.setOtpType("SIGN-IN-ANOTHER-DEVICE");
        otpRepository.save(otpEntity);
    }

    @Override
    public ApiResponse<AuthResponse> verifyOTP(VerifyOTPPayload payload) {
        Date now = new Date();
        OTPEntity otpEntity = otpRepository.findOTPEntityByUsernameAndMatching(payload.getUsername(), false);
        if (otpEntity.getCountWrongOTP() > 3) {
            throw new BadRequestException("You was entered OTP wrong");
        }
        if (!otpEntity.getOtp().equals(payload.getOtp())) {
            otpEntity.setCountWrongOTP(otpEntity.getCountWrongOTP() + 1);
            otpRepository.save(otpEntity);
            throw new BadRequestException("OTP invalid");
        }
        if (now.getTime() > otpEntity.getExpiredDate().getTime()) {
            throw new BadRequestException("OTP can be expire date");
        }
        otpEntity.setMatching(true);
        otpRepository.save(otpEntity);
        AuthenciationEntity authenciation = authenciationRepository.findAuthenciationEntityByUsername(payload.getUsername());
        authenciation.setDeviceId(payload.getDeviceId());
        authenciationRepository.save(authenciation);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(payload.getUsername(), payload.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ApiResponse<>(true, 200, "success", jwtTokenProvider.createAuthResponse(authentication));


    }

    @Override
    public ApiResponse<String> resendOTP(String username) {
        Date now = new Date();
        OTPEntity otpEntity = otpRepository.findOTPEntityByUsernameAndMatching(username, false);
        if (otpEntity.getResendDate().getTime() > now.getTime()) {
            throw new BadRequestException("Resend OTP many request , please send again");
        }
        String otp = GenarateOTP.generateOtp();
        otpEntity.setExpiredDate(new Date(now.getTime() + OTP_EXPIRATION_TIME));
        otpEntity.setResendDate(new Date(now.getTime() + OTP_RESEND_TIME));
        otpEntity.setOtp(otp);
        otpRepository.save(otpEntity);
        return new ApiResponse<>(true, 200, "success", "Resend OTP is success");
    }
}
