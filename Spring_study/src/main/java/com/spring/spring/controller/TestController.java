package com.spring.spring.controller;

import com.spring.spring.service.TestService;
import com.spring.spring.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private TestService testService;

    @Autowired
    public TestController(@Qualifier("testService") TestService testService) {
        this.testService = testService;
    }

    @GetMapping(value = "test")
    @ResponseBody
    public String get(@RequestBody String key) {
        return testService.getVo(key).getName();
    }

    @PostMapping(value = "test")
    @ResponseBody
    public void set(@RequestBody TestVo vo) {
        testService.setVo(vo);
    }
}
