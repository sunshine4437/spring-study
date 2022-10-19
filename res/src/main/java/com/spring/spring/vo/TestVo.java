package com.spring.spring.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "testVo", timeToLive = 30)
public class TestVo {
    private String id;
    private String name;
}
