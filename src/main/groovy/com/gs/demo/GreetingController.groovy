package com.gs.demo

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {
	
	// http://localhost:8080/hello?name=Edgar
	@RequestMapping("/hello")
	def hello(@RequestParam(value="name", defaultValue="World")def name) {
		"Hello, $name!"
	}
	
	@RequestMapping("/greeting")
	def greeting(@RequestParam(value="name", defaultValue="World")def name) {
		def myPerson = new Person(name:name, age:35)
		
		Map<String, Double> mapCryptoCurrency = new HashMap<>()
		mapCryptoCurrency.put "XPR",1.07
		mapCryptoCurrency.put "BTC",2.09
		def virtual = "The price for \"BTC\" is " + mapCryptoCurrency.get("BTC")
		
		ArrayList<String> mylist = new ArrayList<>()
		mylist.add "Grace"
		mylist.add "Rob"
		mylist.add "Emmy"
		
		def myname = myPerson.name
		def myage = myPerson.age
		
		def message = null
		if(mylist.contains(myname)) {
			message = "Welcome come back, $myname!"
		} else if(myage > 18) {
			message = myPerson.sayHello()
		}
		message
	}
	
}

class Person {

	private def name
	private int age
	
	def sayHello() {
		def message = ""
		message = message + "Hello,\n"
		message = message + "My name is: $name\n"
		message = message + "and have $age years old."
		println message
		message
	}
}
