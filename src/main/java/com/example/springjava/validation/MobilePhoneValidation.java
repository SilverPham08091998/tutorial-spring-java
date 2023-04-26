package com.example.springjava.validation;

import com.example.springjava.exception.BadRequestException;
import org.springframework.http.HttpStatus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MobilePhoneValidation {
    public static void validate(String phoneNumber) {
        Pattern pattern = Pattern.compile("(0){0,1}[1-9]{1}[0-9]{8}");
        Matcher matcher = pattern.matcher(phoneNumber);
        if (!matcher.matches()) {
            throw new BadRequestException(String.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.getReasonPhrase(), BadRequestException.class.getTypeName(), "Phone number invalid");
        }
    }

    public static String maskPhoneNumber(String phoneNumber) {
        String outputPhoneNum = phoneNumber.replaceAll("\\d(?=(?:\\D*\\d){3})", "*");
        return outputPhoneNum;
    }
}
