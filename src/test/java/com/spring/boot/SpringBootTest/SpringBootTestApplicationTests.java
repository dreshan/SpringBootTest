package com.spring.boot.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootTestApplicationTests {
	
	@LocalServerPort
	private int port;
	
	private URL base;
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
	}

	@Test
	void contextLoads() throws Exception {
		ResponseEntity<String> response = testRestTemplate.getForEntity(base.toString(), String.class);
		assertThat(response.getBody()).isEqualTo("Greetings from Spring Boot!");
	}

}
