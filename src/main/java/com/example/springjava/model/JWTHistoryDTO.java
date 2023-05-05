package com.example.springjava.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JWTHistoryDTO {

    private String userId;

    private String jti;

    private String ati;

    private String typeToken;

    private Date expireDate;

    private boolean jwtActive;

    private String phoneNumber;

    private String email;

    private String deviceId;
}
