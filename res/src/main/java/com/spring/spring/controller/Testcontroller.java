package com.spring.spring.controller;

import com.spring.spring.vo.TestVo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Testcontroller {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @PostMapping(value = "post")
    public void post() {
        ValueOperations<String, Object> valueOps = redisTemplate.opsForValue();
        valueOps.set("test", "test");
    }

    @GetMapping(value = "get")
    public String get() {
        ValueOperations<String, Object> valueOps = redisTemplate.opsForValue();
        return (String) valueOps.get("test");
    }
}
