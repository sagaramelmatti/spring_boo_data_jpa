package com.demo.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EmployeeConfiguration {
	
	@Bean
	public RestTemplate restTemplateBean() {
	        return new RestTemplate();
	}

}
