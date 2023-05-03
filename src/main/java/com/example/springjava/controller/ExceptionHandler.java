package com.example.springjava.controller;


import com.example.springjava.exception.BadRequestException;
import com.example.springjava.payload.response.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiErrorResponse> handleApiBadRequestException(BadRequestException ex) {
        ApiErrorResponse response = new ApiErrorResponse(ex.getStatus(), ex.getError(),
                ex.getMessage(), ex.getPath());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
