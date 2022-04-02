package com.scdt.assignment.scdtjavaassignment.service;

import org.springframework.stereotype.Service;

@Service
public class SequenceShortDomainNameGenerator implements ShortDomainNameGenerator {
    final Base62ValueGenerator base62ValueGenerator;

    public SequenceShortDomainNameGenerator(Base62ValueGenerator generator) {
        this.base62ValueGenerator = generator;
    }

    public String generateShortDomainName() {
        return "t.cn/" + base62ValueGenerator.generateBase62Value();
    }
}
