package com.example.springjava.security.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class UserDetail {
    private static final long serialVersionUID = -5162456130461860047L;
    private String userId;
    private String username;
    private String password;
    private String role;
    private String phoneNumber;
    private String email;
}
