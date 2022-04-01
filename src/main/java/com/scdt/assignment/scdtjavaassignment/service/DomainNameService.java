package com.scdt.assignment.scdtjavaassignment.service;

import com.scdt.assignment.scdtjavaassignment.exception.DomainNameNotFoundException;
import com.scdt.assignment.scdtjavaassignment.repository.DomainNameRepository;
import com.scdt.assignment.scdtjavaassignment.utils.NumberConverter;
import org.springframework.stereotype.Service;

@Service
public class DomainNameService {

    final DomainNameRepository domainNameRepository;

    final TokenGenerator tokenGenerator;

    public DomainNameService(DomainNameRepository domainNameRepository, TokenGenerator tokenGenerator) {
        this.domainNameRepository = domainNameRepository;
        this.tokenGenerator = tokenGenerator;
    }

    public String encodeLongDomainName(String longDomainName) {
        int token = tokenGenerator.generateToken();
        String shortName = "t.cn/" + NumberConverter.from10baseTo62base(token);
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
