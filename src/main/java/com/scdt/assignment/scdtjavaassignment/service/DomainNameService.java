package com.scdt.assignment.scdtjavaassignment.service;

import com.scdt.assignment.scdtjavaassignment.utils.NumberConverter;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class DomainNameService {

    Map<String,String> domainMappings = new ConcurrentHashMap<>();

    final TokenGenerator tokenGenerator;

    public DomainNameService(TokenGenerator tokenGenerator) {
        this.tokenGenerator = tokenGenerator;
    }

    public String encodeLongDomainName(String longDomainName) {
        int token = tokenGenerator.generateToken();
        String shortName = "t.cn/" + NumberConverter.from10baseTo62base(token);
        domainMappings.put(shortName, longDomainName);
        return shortName;
    }

    public String decodeByShortDomainName(String shortDomainName) {
        return domainMappings.get(shortDomainName);
    }
}
