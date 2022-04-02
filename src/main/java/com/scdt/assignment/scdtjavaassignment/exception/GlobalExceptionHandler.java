package com.scdt.assignment.scdtjavaassignment.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DomainNameNotFoundException.class)
    public ResponseEntity<Object> handleDomainNameNotFoundException(Exception ex) {
        return new ResponseEntity<>(
                ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleCommonException() {
        return new ResponseEntity<>(
                "Something went wrong. Try later", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
