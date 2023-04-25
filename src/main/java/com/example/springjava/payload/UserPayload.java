package com.example.springjava.payload;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = false)
public class UserPayload {

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
