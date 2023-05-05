package com.example.springjava.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JWTExpireDTO {

    private String userId;

    private String jti;

    private String ati;

    private boolean expireStatus;

    private Date expireDate;

    private String deviceId;

    private String typeToken;
}
