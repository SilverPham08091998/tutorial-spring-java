package com.example.springjava.payload.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SignInPayload {
    private String username;
    private String password;
    private String deviceId;
    private String longitude;
    private String latitude;
    private String platform;
}
