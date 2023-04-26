package com.example.springjava.service;

import com.example.springjava.entity.UserEntity;
import com.example.springjava.model.userdto.UserDTO;

import java.util.List;

public interface UserService {

    void createUser(UserEntity userEntity);

    List<UserDTO> getListUser(String fullName, String address, String job);

    void updateUser(UserDTO userDTO, String userId);
}
