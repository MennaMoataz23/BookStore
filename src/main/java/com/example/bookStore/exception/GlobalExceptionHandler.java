package com.example.bookStore.exception;

import com.example.bookStore.web.response.Response;
import com.example.bookStore.model.constants.enums.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.swing.text.html.parser.Entity;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = BadEntryException.class)
    public ResponseEntity<Object> badEntryException(BadEntryException exception) {
        Response<Object> response = Response.builder().message(exception.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .build();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException exception){
        Response<Object> response = Response.builder().message(exception.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.name())
                .build();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}

//generic exception => exception.class
