package com.example.demo.dao;

import com.example.demo.dto.TestDTO;
import com.example.demo.security.CustomUserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface UserDAO {
    public CustomUserDetails getUserById(String id);
}
