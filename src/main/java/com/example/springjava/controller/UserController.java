package com.example.springjava.controller;

import com.example.springjava.entity.UserEntity;
import com.example.springjava.exception.BadRequestException;
import com.example.springjava.model.userdto.ConvertUserDTO;
import com.example.springjava.model.userdto.UserDTO;
import com.example.springjava.payload.ApiResponse;
import com.example.springjava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ConvertUserDTO convertUserDTO;

    @PostMapping(value = "/create")
    @Transactional
    public ResponseEntity<ApiResponse<String>> add(@RequestBody(required = true) UserDTO user) {

        if (user.getFullName().isEmpty() || user.getAddress().isEmpty() || user.getJob().isEmpty() || user.getAge() < 18) {
            throw new BadRequestException(String.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.getReasonPhrase(), BadRequestException.class.getTypeName(), "FullName, Address, Job is Empty");
        }
        try {
            UserEntity userEntity = convertUserDTO.convertToEntity(user);
            userService.createUser(userEntity);

        } catch (Exception e) {
            throw new BadRequestException(String.valueOf(e.hashCode()), e.getMessage(), e.getLocalizedMessage(), e.getClass().getName());
        }
        return ResponseEntity.ok(new ApiResponse<>(true, 200, "success", "It is created"));
    }

    @GetMapping(value = "/list")
    public ResponseEntity<ApiResponse<List<UserDTO>>> getList(
            @RequestParam(name = "fullName", required = false) String fullName,
            @RequestParam(name = "address", required = false) String address,
            @RequestParam(name = "job", required = false) String job

    ) {
        List<UserDTO> userDTOList;
        if (fullName == null || address == null || job == null) {
            throw new BadRequestException(String.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.getReasonPhrase(), BadRequestException.class.getTypeName(), "Params (fullName,address,job) are null");
        }
        try {
            userDTOList = userService.getListUser(fullName, address, job);
        } catch (Exception e) {
            throw new NullPointerException(e.toString());
        }
        return ResponseEntity.ok(new ApiResponse<>(true, 200, "success", userDTOList));
    }
}
