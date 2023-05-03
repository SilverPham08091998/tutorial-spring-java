package com.example.springjava.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse<T> {
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private T data;


    public ApiResponse() {

    }

    public ApiResponse(Boolean success, String message) {
        this.setSuccess(success);
        this.setMessage(message);
    }

    public ApiResponse(Integer code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public ApiResponse(Boolean success, Integer code, String message) {
        this.setSuccess(success);
        this.setMessage(message);
        this.setCode(code);
    }

    public ApiResponse(Boolean success, Integer code, String message, T data) {
        this.setSuccess(success);
        this.setMessage(message);
        this.setCode(code);
        this.setData(data);
    }

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
