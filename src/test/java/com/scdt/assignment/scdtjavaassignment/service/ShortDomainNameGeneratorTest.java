package com.scdt.assignment.scdtjavaassignment.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ShortDomainNameGeneratorTest {

    @InjectMocks
    SequenceShortDomainNameGenerator shortDomainNameGenerator;

    @Mock
    TokenGenerator tokenGenerator;

    @ParameterizedTest
    @CsvSource({"0,0", "35,Z", "3650,ws"})
    public void should_generate_short_domain_names_by_concat_prefix_with_base62_number(
            int token, String base62Number) {
        when(tokenGenerator.generateToken()).thenReturn(token);
        String shortDomainName = shortDomainNameGenerator.generateShortDomainName();
        Assertions.assertEquals("t.cn/" + base62Number, shortDomainName);
    }
}
