package com.example.springjava.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenciationDTO {

    @JsonProperty(value = "username")
    private String username;

    @JsonProperty(value = "password")
    private String password;

    @JsonProperty(value = "deviceId")
    private String deviceId;

    @JsonProperty(value = "longitude")
    private String longitude;

    @JsonProperty(value = "latitude")
    private String latitude;

    @JsonProperty(value = "platform")
    private String platform;

    @JsonProperty(value = "authenciationDate")
    private String authenciationDate;

    @JsonProperty(value = "userId")
    private String userId;

}
