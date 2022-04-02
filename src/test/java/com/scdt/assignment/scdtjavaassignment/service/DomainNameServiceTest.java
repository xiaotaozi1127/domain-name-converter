package com.scdt.assignment.scdtjavaassignment.service;

import com.scdt.assignment.scdtjavaassignment.exception.DomainNameNotFoundException;
import com.scdt.assignment.scdtjavaassignment.repository.DomainNameRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DomainNameServiceTest {

    @Mock
    ShortDomainNameGenerator shortDomainNameGenerator;

    @Mock
    DomainNameRepository domainNameRepository;

    @InjectMocks
    DomainNameService domainNameService;

    @ParameterizedTest
    @CsvSource({"t.cn/0,https://www.baidu.com", "t.cn/Z,https://www.weibo.com",
            "t.cn/ws,https://www.azure.com", "t.cn/UPm,https://www.aws.com"})
    public void should_encode_long_domain_name_to_short_domain_name(
             String shortName, String longName) {
        when(shortDomainNameGenerator.generateShortDomainName()).thenReturn(shortName);
        String encodedName = domainNameService.encodeLongDomainName(longName);
        Mockito.verify(domainNameRepository).saveEncodedDomain(shortName, longName);
        Assertions.assertEquals(shortName, encodedName);
    }

    @ParameterizedTest
    @CsvSource({"t.cn/0,https://www.baidu.com", "t.cn/Z,https://www.weibo.com",
            "t.cn/ws,https://www.azure.com", "t.cn/UPm,https://www.aws.com"})
    public void should_decode_short_domain_name_to_long_domain_name(String shortName, String longName) {
        when(domainNameRepository.decodeShortDomain(shortName)).thenReturn(longName);
        String decodedName = domainNameService.decodeByShortDomainName(shortName);
        Assertions.assertEquals(longName, decodedName);
    }

    @Test
    public void should_throw_exception_if_short_domain_name_can_not_found() {
        String shortDomainName = "t.cn/notfound";
        when(domainNameRepository.decodeShortDomain(shortDomainName)).thenReturn(null);
        Assertions.assertThrows(DomainNameNotFoundException.class,
                ()-> domainNameService.decodeByShortDomainName(shortDomainName));
    }
}
