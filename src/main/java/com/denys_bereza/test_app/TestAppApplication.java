package com.denys_bereza.test_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestAppApplication {

	@RequestMapping("/")
	public String home() {
		return "Docker test! Port 8080";
	}

	public static void main(String[] args) {
		SpringApplication.run(TestAppApplication.class, args);
	}

}
