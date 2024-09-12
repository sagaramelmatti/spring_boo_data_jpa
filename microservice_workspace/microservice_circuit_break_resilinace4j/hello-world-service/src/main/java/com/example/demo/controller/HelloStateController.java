package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/hello/states")
public class HelloStateController {
	
	@GetMapping("/sayHello")
	public String getHelloWorld() {

		return "Hello Sates Called";
	}

}
