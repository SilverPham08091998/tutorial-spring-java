package com.example.springjava.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @JsonProperty(value = "userId")
    private String userId;
    @JsonProperty(value = "fullName")
    private String fullName;

    @JsonProperty(value = "age")
    private int age;

    @JsonProperty(value = "address")
    private String address;

    @JsonProperty(value = "relation")
    private String relation;

    @JsonProperty(value = "job")
    private String job;

    @JsonProperty(value = "createDate")
    private Date createDate;

    @JsonProperty(value = "role")
    private String role;

    @JsonProperty(value = "modifiedDate")
    private String modifiedDate;

    @JsonProperty(value = "titlePosition")
    private String titlePosition;

    @JsonProperty(value = "phoneNumber")
    private String phoneNumber;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "idCard")
    private String idCard;

    @JsonProperty(value = "dateOfBirth")
    private String dateOfBirth;

    @JsonProperty(value = "experiedDate")
    private String experiedDate;

}
