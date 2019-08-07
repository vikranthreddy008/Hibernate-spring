package com.lti.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HelloRestController {
	
	@GetMapping("/hello.lti")

	public @ResponseBody String hello() {
	   return "{\"message\" : \"Welcome to My World\"}";
	   
	   }
}
