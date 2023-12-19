package com.example.spring_securityv2.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class HelloWorldController {

	@GetMapping("/hello")
	public String firstPage() {
		return "Hello World";
	}

}