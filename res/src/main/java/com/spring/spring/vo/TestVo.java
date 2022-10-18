package com.spring.spring.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "test", timeToLive = 30)
@Getter
@Setter
public class TestVo {
    @Id
    private String id;
    private String name;
    private String age;
}
