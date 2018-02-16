package com.gs.demo

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import java.util.ArrayList
import java.util.HashMap
import java.util.Map

@RestController
class GreetingController {

	private static final def template = "Hello, %s!"
	
	// http://localhost:8080/hello?name=Edgar
	@RequestMapping("/hello")
	def hello(@RequestParam(value="name", defaultValue="World")def name) {
		String.format(template, name)
	}
	
	@RequestMapping("/greeting")
	def greeting(@RequestParam(value="name", defaultValue="World")def name) {
		def myPerson = new Person(name)
		myPerson.setAge(35)
		
		Map<String, Double> mapCryptoCurrency = new HashMap<>()
		mapCryptoCurrency.put "XPR",1.07
		mapCryptoCurrency.put "BTC",2.09
		def virtual = "The price for \"BTC\" is " + mapCryptoCurrency.get("BTC")
		
		ArrayList<String> mylist = new ArrayList<>()
		mylist.add "Grace"
		mylist.add "Rob"
		mylist.add "Emmy"
		
		def myname = myPerson.getName()
		def myage = myPerson.getAge()
		
		def message = null
		if(mylist.contains(myname)) {
			message = "Welcome come back, " + myname + "!"
		} else if(myage > 18) {
			message = myPerson.sayHello()
		}
		message
	}
	
}

class Person {

	private def name
	private int age
	
	Person() {		
	}
	
	Person(def name, int age) {
		this.name = name
		this.age = age
	}
	
	Person(def name) {
		this.name = name
	}
	
	def getName() {
		this.name
	}
	
	void setName(def name) {
		this.name = name
	}
	
	int getAge() {
		this.age
	}
	
	void setAge(int age) {
		this.age = age
	}
	
	def sayHello() {
		def message = ""
		message = message + "Hello,\n"
		message = message + "My name is: " + this.name +"\n"
		message = message + "and have "+ this.age + " years old."
		System.out.println message
		message
	}
}
