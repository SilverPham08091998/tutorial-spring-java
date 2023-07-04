package com.example.springjava.validation;

import com.example.springjava.exception.BadRequestException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MobilePhoneValidation {
    public static void validate(String phoneNumber) {
        Pattern pattern = Pattern.compile("(0){0,1}[1-9]{1}[0-9]{8}");
        Matcher matcher = pattern.matcher(phoneNumber);
        if (!matcher.matches()) {
            throw new BadRequestException("Phone number invalid");
        }
    }

    public static String maskPhoneNumber(String phoneNumber) {
        String outputPhoneNum;
        outputPhoneNum = phoneNumber.replaceAll("\\d(?=(?:\\D*\\d){3})", "*");
        return outputPhoneNum;
    }
}
