package com.example.springjava.service;

import com.example.springjava.model.AuthenciationDTO;
import com.example.springjava.model.UserDTO;
import com.example.springjava.security.model.UserDetail;

public interface AuthenciationService {
    UserDetail signUpAccount(UserDTO userDTO, AuthenciationDTO authenciationDTO);

    void signIn();
}
