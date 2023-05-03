package com.example.springjava.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 7664785096389091489L;
    private static final Logger logger = LoggerFactory.getLogger(UnauthorizedException.class);

    public UnauthorizedException(String message) {
        super(message);
        logger.info(MessageFormat.format("UnauthorizedException message: {0}", message));
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
}