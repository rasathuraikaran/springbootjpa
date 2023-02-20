package com.example.springbootjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlienController {
    @RequestMapping("/")
    public String home(){
        System.out.println("Hi thus srk");
        return "home.jsp";
    }

}
