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
        String longName1 = "https://www.baidu.com";
        String longName2 = "https://www.sina.com";

        ResponseEntity<String> responseEntity1 = restTemplate.getForEntity("/domain/encode?longName={longName}",
                String.class, longName1);
        ResponseEntity<String> responseEntity2 = restTemplate.getForEntity("/domain/encode?longName={longName}",
                String.class, longName2);

        HttpStatus statusCode1 = responseEntity1.getStatusCode();
        String body1 = responseEntity1.getBody();
        Assertions.assertEquals(HttpStatus.OK, statusCode1);
        Assertions.assertNotNull(body1);
        Assertions.assertTrue(body1.startsWith("t.cn/"));

        HttpStatus statusCode2 = responseEntity2.getStatusCode();
        String body2 = responseEntity2.getBody();
        Assertions.assertEquals(HttpStatus.OK, statusCode2);
        Assertions.assertNotNull(body2);
        Assertions.assertTrue(body2.startsWith("t.cn/"));

        Assertions.assertNotEquals(body1, body2);
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

    @Test
    public void should_return_not_found_when_decode_not_existed_short_domain_name() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/domain/decode?shortName={shortName}",
                String.class, "t.cn/notfound");
        HttpStatus statusCode = responseEntity.getStatusCode();
        Assertions.assertEquals(HttpStatus.NOT_FOUND, statusCode);
        Assertions.assertEquals("Given short domain name: t.cn/notfound cannot be found",
                responseEntity.getBody());
    }
}
