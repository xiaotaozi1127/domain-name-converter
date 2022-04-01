package com.scdt.assignment.scdtjavaassignment.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SequenceTokenGenerator implements TokenGenerator {

    AtomicInteger atomicInteger = new AtomicInteger();

    public int generateToken() {
        return atomicInteger.incrementAndGet();
    }
}
