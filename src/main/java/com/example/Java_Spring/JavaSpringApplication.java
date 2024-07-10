package com.example.Java_Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JavaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringApplication.class, args);
		System.setProperty("spring.application.admin.enabled", "true");
		// ApplicationContext hoidanIT = SpringApplication.run(JavaSpringApplication.class, args);
		// for (String s : hoidanIT.getBeanDefinitionNames()) {
		// 	System.out.println(s);
		// }

	}
	
}
