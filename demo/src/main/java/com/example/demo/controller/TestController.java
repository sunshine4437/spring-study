package com.example.demo.controller;

import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping(value = "/")
    public String index(Model model) {
        testService.getList().forEach(e -> System.out.println(e.getId() + " " + e.getName() + " " + e.getResultCode()));
        model.addAttribute("data", "test");
        return "index";
    }
}
