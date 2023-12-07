package com.example.carbonproject.controller.advice;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    private final HttpStatus status;

    public HttpStatus getStatus() {
        return status;
    }

    public CustomException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
