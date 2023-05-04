package com.example.springjava.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@EqualsAndHashCode(callSuper = true)
@ResponseStatus(HttpStatus.UNAUTHORIZED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnauthorizedException extends RuntimeException {
    public static final Logger logger = LogManager.getLogger(UnauthorizedException.class);
    private static final long serialVersionUID = 7664785096389091489L;
    private String status;
    private String error;
    private String message;
    private String path;
}