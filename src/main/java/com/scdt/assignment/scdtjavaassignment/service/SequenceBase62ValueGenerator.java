package com.scdt.assignment.scdtjavaassignment.service;

import com.scdt.assignment.scdtjavaassignment.utils.NumberConverter;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SequenceBase62ValueGenerator implements Base62ValueGenerator {

    AtomicInteger atomicInteger = new AtomicInteger();

    public String generateBase62Value() {
        int token = atomicInteger.getAndIncrement();
        return NumberConverter.from10baseTo62base(token);
    }
}
