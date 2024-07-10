package com.example.Java_Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
@SpringBootApplication(
	exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
)
public class JavaSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(JavaSpringApplication.class, args);
	}
	
}
