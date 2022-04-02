package com.scdt.assignment.scdtjavaassignment.service;

import com.scdt.assignment.scdtjavaassignment.utils.NumberConverter;
import org.springframework.stereotype.Service;

@Service
public class SequenceShortDomainNameGenerator implements ShortDomainNameGenerator {
    final TokenGenerator tokenGenerator;

    public SequenceShortDomainNameGenerator(TokenGenerator tokenGenerator) {
        this.tokenGenerator = tokenGenerator;
    }

    public String generateShortDomainName() {
        int token = tokenGenerator.generateToken();
        return "t.cn/" + NumberConverter.from10baseTo62base(token);
    }
}
