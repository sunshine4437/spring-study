package com.spring.spring.repository;

import com.spring.spring.vo.TestVo;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository extends CrudRepository<TestVo, String> {

}
