package com.scdt.assignment.scdtjavaassignment.service;

import com.scdt.assignment.scdtjavaassignment.exception.DomainNameNotFoundException;
import com.scdt.assignment.scdtjavaassignment.repository.DomainNameRepository;
import org.springframework.stereotype.Service;

@Service
public class DomainNameService {

    final DomainNameRepository domainNameRepository;
    final ShortDomainNameGenerator shortDomainNameGenerator;

    public DomainNameService(DomainNameRepository domainNameRepository,
                             ShortDomainNameGenerator shortDomainNameGenerator) {
        this.domainNameRepository = domainNameRepository;
        this.shortDomainNameGenerator = shortDomainNameGenerator;
    }

    public String encodeLongDomainName(String longDomainName) {
        String shortName = shortDomainNameGenerator.generateShortDomainName();
        domainNameRepository.saveEncodedDomain(shortName, longDomainName);
        return shortName;
    }

    public String decodeByShortDomainName(String shortDomainName) {
        String domain = domainNameRepository.decodeShortDomain(shortDomainName);
        if (domain == null) {
            throw new DomainNameNotFoundException(shortDomainName);
        }
        return domain;
    }
}
