package com.lti.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hello.lti")
	public String hello(Map<String, Object> model) {
		model.put("message","Welcome to spring MVC");
		return "index.html";
		
	}
}
