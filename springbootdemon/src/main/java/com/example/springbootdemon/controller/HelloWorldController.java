package com.example.springbootdemon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
}
