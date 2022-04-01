package com.scdt.assignment.scdtjavaassignment.repository;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemoryDomainNameRepository implements DomainNameRepository {
    Map<String,String> domainMappings = new ConcurrentHashMap<>();

    public void saveEncodedDomain(String shortDomain, String longDomain) {
        domainMappings.put(shortDomain, longDomain);
    }

    public String decodeShortDomain(String shortDomain) {
        return domainMappings.get(shortDomain);
    }
}
