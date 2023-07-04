package com.example.springjava.controller;

import com.example.springjava.exception.BadRequestException;
import com.example.springjava.model.UserDTO;
import com.example.springjava.payload.request.UpdateUserPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ModelMapper mapper;


    @GetMapping(value = "/list")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ApiResponse<List<UserDTO>>> getList(
            @RequestParam(name = "fullName", required = false) String fullName,
            @RequestParam(name = "address", required = false) String address,
            @RequestParam(name = "job", required = false) String job

    ) {
        List<UserDTO> userDTOList;
        if (fullName == null || address == null || job == null) {
            throw new BadRequestException("Params (fullName,address,job) are null");
        }
        try {
            userDTOList = userService.getListUser(fullName, address, job);
        } catch (Exception e) {
            throw new NullPointerException(e.toString());
        }
        return ResponseEntity.ok(new ApiResponse<>(true, 200, "success", userDTOList));
    }

    @PostMapping(value = "/update")
    @Transactional
    public ResponseEntity<ApiResponse<String>> updateUser(
            @RequestBody UpdateUserPayload payload
    ) {
        try {
            userService.updateUser(payload.getUserId(), payload.getUserDTO());
        } catch (Exception e) {
            throw new BadRequestException("UserId is invalid");

        }
        return ResponseEntity.ok(new ApiResponse<>(true, 200, "success", "Update success"));
    }

    @PutMapping(value = "/update")
    @Transactional
    public ResponseEntity<ApiResponse<String>> updateFullNameUser(
            @RequestBody Map<String, Object> body
    ) {
        try {
            userService.updateFullNameByUserId(body.get("userId").toString(), body.get("fullName").toString(), (int) body.get("age"));
        } catch (Exception e) {
            throw new BadRequestException("UserId is invalid");

        }
        return ResponseEntity.ok(new ApiResponse<>(true, 200, "success", "Update Full Name success"));
    }

    @DeleteMapping(value = "/delete")
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ApiResponse<String>> deleteUser(
            @RequestBody Map<String, String> userId
    ) {
        try {
            userService.deleteUser(userId.get("userId"));
        } catch (Exception e) {
            throw new BadRequestException("UserId is invalid");
        }
        return ResponseEntity.ok(new ApiResponse<>(true, 200, "success", "Delete success"));
    }

    @PostMapping(value = "/role/create")
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ApiResponse<String>> createRole(
            @RequestBody Map<String, String> roleName
    ) {
        try {
            userService.createRole(roleName.get("roleName"));
        } catch (Exception e) {
            throw new BadRequestException("UserId is invalid");
        }
        return ResponseEntity.ok(new ApiResponse<>(true, 200, "success", "Create Role success"));
    }
}
