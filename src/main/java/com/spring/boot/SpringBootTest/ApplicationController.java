package com.spring.boot.SpringBootTest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

	@RequestMapping("/ApplicationController")
	public String getBootResponse() {
		return "Greetings from Spring Boot!";
	}
	
}
