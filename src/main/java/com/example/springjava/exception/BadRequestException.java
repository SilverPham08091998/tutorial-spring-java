package com.example.springjava.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BadRequestException extends RuntimeException {
    private static final long serialVersionUID = 7664785096389091489L;
    private static final Logger logger = LoggerFactory.getLogger(BadRequestException.class);
    private String codeError;
    private String titleError;
    private String messageError;
    private String detailError;

}
