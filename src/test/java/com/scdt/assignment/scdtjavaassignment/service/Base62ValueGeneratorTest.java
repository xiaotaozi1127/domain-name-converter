package com.scdt.assignment.scdtjavaassignment.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Base62ValueGeneratorTest {

    @Test
    public void should_generate_base_62_value_by_sequence() {
        Base62ValueGenerator base62ValueGenerator = new SequenceBase62ValueGenerator();
        for (int i = 0; i < 10; i++) {
            String base62Value = base62ValueGenerator.generateBase62Value();
            Assertions.assertEquals(String.valueOf(i), base62Value);
        }
    }
}
