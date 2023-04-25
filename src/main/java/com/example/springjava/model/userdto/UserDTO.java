package com.example.springjava.model.userdto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
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
}
