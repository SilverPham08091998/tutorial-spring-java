package com.example.springjava.controller;


import com.example.springjava.exception.BadRequestException;
import com.example.springjava.exception.ForbiddenException;
import com.example.springjava.exception.UnauthorizedException;
import com.example.springjava.payload.response.ApiErrorResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class ExceptionHandler {
    private static final ObjectMapper mapper = new ObjectMapper();
    public final String system = "MOBILE_CX";


    @org.springframework.web.bind.annotation.ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiErrorResponse> handleApiBadRequestException(BadRequestException ex) {
        ApiErrorResponse response = new ApiErrorResponse(ex.getStatus(), ex.getError(),
                ex.getMessage(), ex.getPath());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ApiErrorResponse> handleForbiddenException(ForbiddenException ex) {
        ApiErrorResponse response = new ApiErrorResponse(ex.getStatus(), ex.getError(),
                ex.getMessage(), ex.getPath());
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ApiErrorResponse> handleUnauthrizationException(UnauthorizedException ex) {
        ApiErrorResponse response = new ApiErrorResponse(ex.getStatus(), ex.getError(),
                ex.getMessage(), ex.getPath());
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<JsonNode> handleApiExceptionException(HttpClientErrorException e) {
        return redirectHttpClientErrorException(e);
    }

    private String getValueFromResponse(JsonNode bodyObject, String key) {
        return bodyObject.has(key) ? bodyObject.get(key).asText() : null;
    }

    private ResponseEntity<JsonNode> redirectHttpClientErrorException(HttpClientErrorException e) {
        String description = null;
        String message = null;
        JsonNode bodyObject = null;
        try {
            bodyObject = mapper.readTree(e.getResponseBodyAsString());
            description = getValueFromResponse(bodyObject, "description");
            message = getValueFromResponse(bodyObject, "message");
        } catch (Exception e3) {
            try {
                description = "HttpClientErrorException: " + e.getResponseBodyAsString();
            } catch (Exception e1) {
                description = "HttpClientErrorException: " + e;
            }
        }

        JsonNode response = mapper.valueToTree(new ApiErrorResponse(e.getStatusCode().toString(), message,
                message, description));

        switch (e.getStatusCode()) {
            case BAD_REQUEST:
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            case CONFLICT:
                return new ResponseEntity<>(response, HttpStatus.CONFLICT);
            case EXPECTATION_FAILED:
                return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
            case FORBIDDEN:
                return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
            case LOCKED:
                return new ResponseEntity<>(response, HttpStatus.LOCKED);
            case REQUEST_TIMEOUT:
                return new ResponseEntity<>(response, HttpStatus.REQUEST_TIMEOUT);
            case NOT_FOUND:
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            case TOO_MANY_REQUESTS:
                return new ResponseEntity<>(response, HttpStatus.TOO_MANY_REQUESTS);
            case UNAUTHORIZED:
                return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
            case FAILED_DEPENDENCY:
                return new ResponseEntity<>(response, HttpStatus.FAILED_DEPENDENCY);
            default:
                throw e;
        }
    }


}
