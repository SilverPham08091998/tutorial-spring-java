package com.example.springjava.controller;

import com.example.springjava.entity.UserEntity;
import com.example.springjava.exception.BadRequestException;
import com.example.springjava.model.userdto.ConvertUserDTO;
import com.example.springjava.model.userdto.UserDTO;
import com.example.springjava.payload.ApiResponse;
import com.example.springjava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<String>> add(@RequestBody(required = true) UserDTO user) {
        try {
            UserEntity userEntity = convertUserDTO.convertToEntity(user);
            userService.createUser(userEntity);

        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
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
        try {
            userDTOList = userService.getListUser(fullName, address, job);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
        return ResponseEntity.ok(new ApiResponse<>(true, 200, "success", userDTOList));
    }
}
