package com.scdt.assignment.scdtjavaassignment.controller;

import com.scdt.assignment.scdtjavaassignment.service.DomainNameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("domain")
public class DomainNameController {

    final DomainNameService domainNameService;

    public DomainNameController(DomainNameService domainNameService) {
        this.domainNameService = domainNameService;
    }

    @GetMapping("/encode")
    public String shortenDomainName(@RequestParam("longName") String longDomainName) {
        return domainNameService.encodeLongDomainName(longDomainName);
    }

    @GetMapping("/decode")
    public String decodeDomainName(@RequestParam("shortName") String shortDomainName) {
        return domainNameService.decodeByShortDomainName(shortDomainName);
    }
}
