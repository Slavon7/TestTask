package com.example.testtask.EmployeeController_e2e;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerE2ETest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetEmployeeById() {
        int id = 1;
        String expectedFirstName = "Vyacheslav";
        String expectedLastName = "Omenyuk";
        int expectedAge = 18;

        ResponseEntity<Map> response = restTemplate.getForEntity("/employee/" + id, Map.class);
        Map<String, Object> body = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(id, body.get("id"));
        assertEquals(expectedFirstName, body.get("firstName"));
        assertEquals(expectedLastName, body.get("lastName"));
        assertEquals(expectedAge, body.get("age"));
    }
}