package com.student.student_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@ComponentScan({"com.student.student_service.controller","com.student.student_service.service"})
@EntityScan("com.student.student_service.entity")
@EnableJpaRepositories("com.student.student_service.repository")
@Configuration
public class StudentServiceApplication {
	
	@Value("${address.service.url}")
	private String addressServiceUrl;

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}
	@Bean
	public WebClient webClient() {
		 
		WebClient webClient=WebClient.builder().baseUrl(addressServiceUrl).build();
		return webClient;
		
	}

}
