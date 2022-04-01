package com.scdt.assignment.scdtjavaassignment.exception;

public class DomainNameNotFoundException extends RuntimeException {
    public DomainNameNotFoundException(String message) {
        super("Given short domain name: " + message + " cannot be found");
    }
}
