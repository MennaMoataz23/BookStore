package com.example.bookStore.exception;

import com.example.bookStore.web.response.Response;
import com.example.bookStore.model.constants.enums.Error;

public class BadEntryException extends RuntimeException{
    public BadEntryException(String message) {
        super(message);
    }
}