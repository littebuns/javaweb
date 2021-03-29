package com.chidan.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Scope("")
@RestController
public class UserController {

    @GetMapping("/test")
    public String test(){
        return "hello world";
    }

}
