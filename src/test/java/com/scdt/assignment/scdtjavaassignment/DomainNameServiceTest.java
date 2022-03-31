package com.scdt.assignment.scdtjavaassignment;

import com.scdt.assignment.scdtjavaassignment.service.DomainNameService;
import com.scdt.assignment.scdtjavaassignment.service.TokenGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DomainNameServiceTest {

    @Mock
    TokenGenerator tokenGenerator;

    @InjectMocks
    DomainNameService domainNameService;

    @ParameterizedTest
    @CsvSource({"0,0,https://www.baidu.com", "35,Z,https://www.weibo.com",
            "3650,ws,https://www.azure.com", "116918,UPm,https://www.aws.com"})
    public void should_encode_long_domain_name_to_short_domain_name_and_decode_back(
            int token, String name, String longName) {
        when(tokenGenerator.generateToken()).thenReturn(token);
        String shortName = domainNameService.encodeLongDomainName(longName);
        Assertions.assertEquals("t.cn/" + name, shortName);
        Assertions.assertEquals(longName, domainNameService.decodeByShortDomainName(shortName));
    }
}
