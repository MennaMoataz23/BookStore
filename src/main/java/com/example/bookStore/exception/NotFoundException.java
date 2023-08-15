package com.example.bookStore.exception;

import com.example.bookStore.web.response.Response;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
