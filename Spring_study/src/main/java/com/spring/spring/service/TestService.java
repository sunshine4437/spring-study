package com.spring.spring.service;

import com.spring.spring.config.RedisConfig;
import com.spring.spring.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class TestService {
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public TestService(@Qualifier("redisTemplate") RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setVo(TestVo vo) {
        HashOperations<String, String, TestVo> hashOps = redisTemplate.opsForHash();
        hashOps.put("vo", vo.getId(), vo);

        ListOperations<String, Object> listOps = redisTemplate.opsForList();
        redisTemplate.expire("key", 5, TimeUnit.SECONDS);
        listOps.rightPush("key", "value");
    }

    public TestVo getVo(String key) {
        HashOperations<String, String, TestVo> hashOps = redisTemplate.opsForHash();
        ListOperations<String, Object> listOps = redisTemplate.opsForList();
        Objects.requireNonNull(listOps.range("key", 0, -1)).forEach(System.out::println);
        return hashOps.get("vo", key);
    }
}
