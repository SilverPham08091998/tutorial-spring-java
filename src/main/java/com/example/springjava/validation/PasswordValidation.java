package com.example.springjava.validation;

import com.example.springjava.exception.BadRequestException;

public class PasswordValidation {

    public static void checkPasswordPolicy(String password) {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z\\d\\s:])(?=\\S+$).{8,16}$";
        if (!password.matches(pattern)) {
            throw new BadRequestException();
        }
    }
}
