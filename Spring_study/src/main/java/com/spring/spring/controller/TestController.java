package com.spring.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class TestController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @GetMapping(value = "test")
    @ResponseBody
    public String getTest(HttpServletRequest request) {
        ValueOperations<String, Object> valueOps = redisTemplate.opsForValue();
        valueOps.set("test", "test");
        return (String) valueOps.get("test");
    }

    @PostMapping(value = "test")
    @ResponseBody
    public String postTest(@RequestBody Map<String, Object> data) {
        return "index";
    }
}
