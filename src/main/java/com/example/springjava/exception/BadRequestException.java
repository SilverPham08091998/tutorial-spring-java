package com.example.springjava.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
    private static final long serialVersionUID = 7664785096389091489L;
    private static final Logger logger = LoggerFactory.getLogger(BadRequestException.class);
    private final String errorCode;

    public BadRequestException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        logger.error(MessageFormat.format("BadRequestException message: {0}", message));
    }

    public BadRequestException(String message) {
        super(message);
        this.errorCode = "";
        logger.error(MessageFormat.format("BadRequestException message: {0}", message));
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = "";
    }

    public BadRequestException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }
}
