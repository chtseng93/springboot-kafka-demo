package com.example.springboot_kafka_demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestController {
	@GetMapping("/helloworld")
	public String getHello(){
		
		return "hello";
		
	}

}
