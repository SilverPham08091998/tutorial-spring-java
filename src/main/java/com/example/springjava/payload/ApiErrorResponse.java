package com.example.springjava.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ApiErrorResponse {

    @JsonProperty("code")
    private String error;
    @JsonProperty("message")

    private String message;
    @JsonProperty("type")

    private String title;
    @JsonProperty("detail")

    private String detail;

    public ApiErrorResponse(String error, String message, String title, String detail) {
        super();
        this.error = error;
        this.message = message;
        this.title = title;
        this.detail = detail;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
