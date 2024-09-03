package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/hello")
public class HelloWorldController {
	
	@GetMapping("/sayHello")
	public String getHelloWorld() {

		//throw new RuntimeException("Runtime exception");
		return "Hello world";
		
	}

}
