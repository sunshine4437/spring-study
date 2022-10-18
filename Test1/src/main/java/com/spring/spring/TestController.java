package com.spring.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(value = "/test1")
    public String test1(){
        return "test1";
    }
    @GetMapping(value = "/test2")
    public String test2(){
        return "test2";
    }
}
