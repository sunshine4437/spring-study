package com.example.demo.controller;

import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
//@RequestMapping(value = "/")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping(value = "/index")
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
        String str = (String) request.getSession().getAttribute("test");
        if (str == null) {
            request.getSession().setAttribute("test", "test");
        } else {
            System.out.println(str);
        }

        model.addAttribute("data", "test");
        return "index";
    }

    @GetMapping(value = "/sign-up")
    public String signUp() {
        return "auth/sign-up";
    }

    @GetMapping(value = "/sign-in")
    public String signIn() {
        return "auth/sign-in";
    }

}
