package com.example.springjava.payload.request;

import com.example.springjava.model.AuthenciationDTO;
import com.example.springjava.model.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenciationPayload {

    AuthenciationDTO authenciationDTO;

    UserDTO userDTO;
}
