package com.example.springjava.payload.response;


import lombok.Data;

@Data
public class AuthResponse {
    private String token_type;
    private String access_token;
    private String refresh_token;
    private String jti;

    public AuthResponse(String access_token, String refresh_token, String jti) {
        this.access_token = access_token;
        this.refresh_token = refresh_token;
        this.jti = jti;
        this.token_type = "Bearer";
    }
}
