package com.scdt.assignment.scdtjavaassignment.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface DomainNameRepository {
    void saveEncodedDomain(String shortDomain, String longDomain);

    String decodeShortDomain(String shortDomain);

}
