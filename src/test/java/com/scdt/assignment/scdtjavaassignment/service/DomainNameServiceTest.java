package com.scdt.assignment.scdtjavaassignment.service;

import com.scdt.assignment.scdtjavaassignment.exception.DomainNameNotFoundException;
import com.scdt.assignment.scdtjavaassignment.repository.DomainNameRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

    @Test
    public void should_encode_long_domain_name_to_short_domain_name() {
        String shortName = "t.cn/ws";
        when(shortDomainNameGenerator.generateShortDomainName()).thenReturn(shortName);

        String longDomainName = "https://www.azure.com";
        String encodedName = domainNameService.encodeLongDomainName(longDomainName);

        Mockito.verify(domainNameRepository).saveEncodedDomain(shortName, longDomainName);
        Assertions.assertEquals(shortName, encodedName);
    }

    @Test
    public void should_decode_short_domain_name_to_long_domain_name() {
        String shortDomain = "t.cn/UPm";
        String longDomain = "https://www.aws.com";
        when(domainNameRepository.decodeShortDomain(shortDomain)).thenReturn(longDomain);

        String decodedName = domainNameService.decodeByShortDomainName(shortDomain);

        Assertions.assertEquals(longDomain, decodedName);
    }

    @Test
    public void should_throw_exception_if_short_domain_name_can_not_found() {
        String shortDomainName = "t.cn/notfound";
        when(domainNameRepository.decodeShortDomain(shortDomainName)).thenReturn(null);

        Assertions.assertThrows(DomainNameNotFoundException.class,
                ()-> domainNameService.decodeByShortDomainName(shortDomainName));
    }
}
