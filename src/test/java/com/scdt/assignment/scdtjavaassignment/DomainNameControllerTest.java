package com.scdt.assignment.scdtjavaassignment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DomainNameControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void should_shorten_a_long_domain_name() {
        String longName = "https://www.baidu.com";

        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/domain/encode?longName={longName}",
                String.class, longName);

        HttpStatus statusCode = responseEntity.getStatusCode();
        Assertions.assertEquals(HttpStatus.OK, statusCode);
    }
}
