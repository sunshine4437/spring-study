package com.spring.spring.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Setter
@Getter
public class TestVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;

}
