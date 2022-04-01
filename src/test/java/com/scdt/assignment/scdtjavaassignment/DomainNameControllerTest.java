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
    public void should_encode_a_long_domain_name_to_a_short_domain_name() {
        String longName = "https://www.baidu.com";

        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/domain/encode?longName={longName}",
                String.class, longName);

        HttpStatus statusCode = responseEntity.getStatusCode();
        String body = responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, statusCode);
        Assertions.assertNotNull(body);
        Assertions.assertTrue(body.startsWith("t.cn/"));
    }

    @Test
    public void should_decode_short_domain_name_to_long_domain_name() {
        String longName = "https://www.baidu.com";
        String shortName = restTemplate.getForObject("/domain/encode?longName={longName}",
                String.class, longName);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/domain/decode?shortName={shortName}",
                String.class, shortName);
        HttpStatus statusCode = responseEntity.getStatusCode();
        String body = responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, statusCode);
        Assertions.assertNotNull(body);
        Assertions.assertEquals(longName, body);
    }
}
