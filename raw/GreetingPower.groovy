package com.gs.demo

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingPower {

    // http://localhost:8080/hello?name=Edgar
    @RequestMapping("/hello")
    public String greeting(String name) {
        return "Hello, ${name?:'World'}!"
    }
}