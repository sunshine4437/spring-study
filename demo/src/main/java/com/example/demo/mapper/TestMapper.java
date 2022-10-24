package com.example.demo.mapper;

import com.example.demo.dto.TestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface TestMapper {
    public List<TestDTO> getList();
}
