package com.scdt.assignment.scdtjavaassignment.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumberConverterTest {
    @ParameterizedTest
    @CsvSource({"0,0", "9,9", "10,A", "35,Z", "36,a", "61,z", "62,10", "93,1V", "3650,ws", "116918,UPm"})
    public void should_convert_10base_to_62base_when_input_less_than_62(int input, String output) {
        String to62base = NumberConverter.from10baseTo62base(input);
        Assertions.assertEquals(output, to62base);
    }

    @ParameterizedTest
    @CsvSource({"0,0", "9,9", "A,10", "Z,35", "a,36", "z,61", "10,62","1V,93", "ws,3650", "UPm,116918"})
    public void should_convert_62base_to_10base_when_input_is_valid(String input, int output) {
        int to10base = NumberConverter.from62baseTo10base(input);
        Assertions.assertEquals(output, to10base);
    }
}
