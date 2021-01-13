package com.myl.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CakeDealController {
    @RequestMapping("/demo")
    public String run() {
        return "hello word";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }
}
