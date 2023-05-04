package com.example.springjava.payload.request;

import com.example.springjava.model.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserPayload {
    private UserDTO userDTO;
    private String userId;
}
