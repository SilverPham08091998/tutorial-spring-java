package com.example.springjava.controller;


import com.example.springjava.exception.BadRequestException;
import com.example.springjava.payload.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiErrorResponse> handleApiBadRequestException(BadRequestException ex) {
        ApiErrorResponse response = new ApiErrorResponse(ex.getCodeError(), ex.getTitleError(),
                ex.getMessageError(), ex.getDetailError());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
