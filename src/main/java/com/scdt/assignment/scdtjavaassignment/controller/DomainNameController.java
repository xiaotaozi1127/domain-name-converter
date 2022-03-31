package com.scdt.assignment.scdtjavaassignment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("domain")
public class DomainNameController {

    @GetMapping("/encode")
    public String shortenDomainName(@RequestParam("longName") String longDomainName) {
        return null;
    }

}
