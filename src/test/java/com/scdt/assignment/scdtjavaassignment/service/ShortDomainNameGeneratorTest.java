package com.scdt.assignment.scdtjavaassignment.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ShortDomainNameGeneratorTest {

    @InjectMocks
    SequenceShortDomainNameGenerator shortDomainNameGenerator;

    @Mock
    Base62ValueGenerator base62ValueGenerator;

    @Test
    public void should_generate_short_domain_names_by_concat_prefix_with_base62_number() {
        when(base62ValueGenerator.generateBase62Value()).thenReturn("NM6D");

        String shortDomainName = shortDomainNameGenerator.generateShortDomainName();

        Assertions.assertEquals("http://t.cn/NM6D", shortDomainName);
        Mockito.verify(base62ValueGenerator).generateBase62Value();
    }
}
