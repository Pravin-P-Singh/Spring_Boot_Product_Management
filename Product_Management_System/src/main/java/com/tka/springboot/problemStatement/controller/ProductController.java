package com.tka.springboot.problemStatement.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@RequestMapping("/hello/{name}")
	public String simple(@PathVariable String name) {
		return "Hello "+name;
	}
}
