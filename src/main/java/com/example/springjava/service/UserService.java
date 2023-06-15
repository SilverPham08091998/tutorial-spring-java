package com.example.springjava.service;

import com.example.springjava.model.UserDTO;

import java.util.List;

public interface UserService {


    List<UserDTO> getListUser(String fullName, String address, String job);

    void updateFullNameByUserId(String userId, String fullName, int age);

    void updateUser(String userId, UserDTO userDTO);

    void deleteUser(String userId);
    
    void createRole(String roleName);

    void updateRole(long roleId);

    void deleteRole(long roleId);
}
