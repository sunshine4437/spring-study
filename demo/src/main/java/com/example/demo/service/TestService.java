package com.example.demo.service;

import com.example.demo.dto.TestDTO;
import com.example.demo.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private TestMapper testMapper;

    @Autowired
    public TestService(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    public List<TestDTO> getList() {
        return testMapper.getList();
    }

}
