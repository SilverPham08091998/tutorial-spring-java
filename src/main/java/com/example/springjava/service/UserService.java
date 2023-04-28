package com.example.springjava.service;

import com.example.springjava.entity.UserEntity;
import com.example.springjava.model.UserDTO;

import java.util.List;

public interface UserService {

    void createUser(UserEntity userEntity);

    List<UserDTO> getListUser(String fullName, String address, String job);

    void updateFullNameByUserId(String userId, String fullName, int age);

    void updateUser(String userId, UserDTO userDTO);


    void deleteUser(String userId);
}
