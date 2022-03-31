package com.scdt.assignment.scdtjavaassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScdtJavaAssignmentApplication {

    public static void main(String[] args) {
        String CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int w = CHARS.indexOf("w");
        int s = CHARS.indexOf("s");

        SpringApplication.run(ScdtJavaAssignmentApplication.class, args);
    }

}
