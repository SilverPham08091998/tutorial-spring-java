package com.example.springjava.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;


public class CustomHttpClientErrorException {
    private static final Logger logger = LogManager.getLogger(CustomHttpClientErrorException.class);
    private int status;
    private String error;
    private String message;
    private String path;
    private String errorCode;

    public CustomHttpClientErrorException(HttpClientErrorException e) {
        try {
            this.status = e.getStatusCode().value();
            JSONObject bodyObject = new JSONObject(e.getResponseBodyAsString());
            this.message = bodyObject.getString("message");
            this.error = bodyObject.getString("error");
            this.path = bodyObject.getString("path");
            this.errorCode = bodyObject.getString("errorCode");
        } catch (JSONException var4) {
            logger.info(var4.toString());
        }

    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}

