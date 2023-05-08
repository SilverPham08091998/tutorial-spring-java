package com.example.springjava.util;

import java.util.Random;

public class GenarateOTP {

    public static String generateOtp() {
        Random random = new Random();
        int otpLength = 6;
        StringBuilder otp = new StringBuilder(otpLength);
        for (int i = 0; i < otpLength; i++) {
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }

}
