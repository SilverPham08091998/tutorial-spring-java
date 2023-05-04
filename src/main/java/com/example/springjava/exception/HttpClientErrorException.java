package com.example.springjava.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.client.HttpStatusCodeException;

import java.nio.charset.Charset;

public class HttpClientErrorException extends HttpStatusCodeException {
    private static final long serialVersionUID = 5177019431887513952L;

    public HttpClientErrorException(HttpStatus statusCode) {
        super(statusCode);
    }

    public HttpClientErrorException(HttpStatus statusCode, String statusText) {
        super(statusCode, statusText);
    }

    public HttpClientErrorException(HttpStatus statusCode, String statusText, @Nullable byte[] body, @Nullable Charset responseCharset) {
        super(statusCode, statusText, body, responseCharset);
    }

    public HttpClientErrorException(HttpStatus statusCode, String statusText, @Nullable HttpHeaders headers, @Nullable byte[] body, @Nullable Charset responseCharset) {
        super(statusCode, statusText, headers, body, responseCharset);
    }

    public static org.springframework.web.client.HttpClientErrorException create(HttpStatus statusCode, String statusText, HttpHeaders headers, byte[] body, @Nullable Charset charset) {
        switch (statusCode) {
            case BAD_REQUEST:
                return new BadRequest(statusText, headers, body, charset);
            case UNAUTHORIZED:
                return new Unauthorized(statusText, headers, body, charset);
            case FORBIDDEN:
                return new Forbidden(statusText, headers, body, charset);
            case NOT_FOUND:
                return new NotFound(statusText, headers, body, charset);
            case METHOD_NOT_ALLOWED:
                return new MethodNotAllowed(statusText, headers, body, charset);
            case NOT_ACCEPTABLE:
                return new NotAcceptable(statusText, headers, body, charset);
            case CONFLICT:
                return new Conflict(statusText, headers, body, charset);
            case GONE:
                return new Gone(statusText, headers, body, charset);
            case UNSUPPORTED_MEDIA_TYPE:
                return new UnsupportedMediaType(statusText, headers, body, charset);
            case TOO_MANY_REQUESTS:
                return new TooManyRequests(statusText, headers, body, charset);
            case UNPROCESSABLE_ENTITY:
                return new UnprocessableEntity(statusText, headers, body, charset);
            default:
                return new org.springframework.web.client.HttpClientErrorException(statusCode, statusText, headers, body, charset);
        }
    }

    public static class TooManyRequests extends org.springframework.web.client.HttpClientErrorException {
        TooManyRequests(String statusText, HttpHeaders headers, byte[] body, @Nullable Charset charset) {
            super(HttpStatus.TOO_MANY_REQUESTS, statusText, headers, body, charset);
        }
    }

    public static class UnprocessableEntity extends org.springframework.web.client.HttpClientErrorException {
        UnprocessableEntity(String statusText, HttpHeaders headers, byte[] body, @Nullable Charset charset) {
            super(HttpStatus.UNPROCESSABLE_ENTITY, statusText, headers, body, charset);
        }
    }

    public static class UnsupportedMediaType extends org.springframework.web.client.HttpClientErrorException {
        UnsupportedMediaType(String statusText, HttpHeaders headers, byte[] body, @Nullable Charset charset) {
            super(HttpStatus.UNSUPPORTED_MEDIA_TYPE, statusText, headers, body, charset);
        }
    }

    public static class Gone extends org.springframework.web.client.HttpClientErrorException {
        Gone(String statusText, HttpHeaders headers, byte[] body, @Nullable Charset charset) {
            super(HttpStatus.GONE, statusText, headers, body, charset);
        }
    }

    public static class Conflict extends org.springframework.web.client.HttpClientErrorException {
        Conflict(String statusText, HttpHeaders headers, byte[] body, @Nullable Charset charset) {
            super(HttpStatus.CONFLICT, statusText, headers, body, charset);
        }
    }

    public static class NotAcceptable extends org.springframework.web.client.HttpClientErrorException {
        NotAcceptable(String statusText, HttpHeaders headers, byte[] body, @Nullable Charset charset) {
            super(HttpStatus.NOT_ACCEPTABLE, statusText, headers, body, charset);
        }
    }

    public static class MethodNotAllowed extends org.springframework.web.client.HttpClientErrorException {
        MethodNotAllowed(String statusText, HttpHeaders headers, byte[] body, @Nullable Charset charset) {
            super(HttpStatus.METHOD_NOT_ALLOWED, statusText, headers, body, charset);
        }
    }

    public static class NotFound extends org.springframework.web.client.HttpClientErrorException {
        NotFound(String statusText, HttpHeaders headers, byte[] body, @Nullable Charset charset) {
            super(HttpStatus.NOT_FOUND, statusText, headers, body, charset);
        }
    }

    public static class Forbidden extends org.springframework.web.client.HttpClientErrorException {
        Forbidden(String statusText, HttpHeaders headers, byte[] body, @Nullable Charset charset) {
            super(HttpStatus.FORBIDDEN, statusText, headers, body, charset);
        }
    }

    public static class Unauthorized extends org.springframework.web.client.HttpClientErrorException {
        Unauthorized(String statusText, HttpHeaders headers, byte[] body, @Nullable Charset charset) {
            super(HttpStatus.UNAUTHORIZED, statusText, headers, body, charset);
        }
    }

    public static class BadRequest extends org.springframework.web.client.HttpClientErrorException {
        BadRequest(String statusText, HttpHeaders headers, byte[] body, @Nullable Charset charset) {
            super(HttpStatus.BAD_REQUEST, statusText, headers, body, charset);
        }
    }
}

