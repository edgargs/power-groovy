package com.gs.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	
	// http://localhost:8080/greeting?name=Edgar
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value="name", defaultValue="World")String name) {
		return String.format(template, name);
	}
	
}
