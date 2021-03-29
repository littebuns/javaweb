package com.chidan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @GetMapping("null")
    public void test(@RequestParam(value = "test", required = false) String test){
        System.out.println(test.toString());
    }

}
