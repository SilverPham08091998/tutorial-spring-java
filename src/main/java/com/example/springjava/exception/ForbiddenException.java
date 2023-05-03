package com.example.springjava.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 7664785096389091489L;
    private static final Logger logger = LoggerFactory.getLogger(ForbiddenException.class);

    public ForbiddenException(String message) {
        super(message);
        logger.info(MessageFormat.format("ForbiddenException message: {0}", message));
    }

    public ForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }
}