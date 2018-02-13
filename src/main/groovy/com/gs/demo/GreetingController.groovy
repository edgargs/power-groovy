package com.gs.demo;

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
	
	@RequestMapping("/greetingPerson")
	public String greetingPerson(@RequestParam(value="name", defaultValue="World")String name) {
		Person myPerson = new Person(name);
		myPerson.setAge(35);		
		return myPerson.sayHello();
	}
	
}

public class Person {

	private String name;
	private int age;
	
	public Person() {		
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String sayHello() {
		String message = "";
		message = message + "Hello,\n";
		message = message + "My name is: " + this.name +"\n";
		message = message + "and have "+ this.age + " years old.";
		System.out.println(message);
		return message;
	}
}
