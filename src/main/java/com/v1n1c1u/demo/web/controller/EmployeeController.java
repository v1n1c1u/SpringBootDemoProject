package com.v1n1c1u.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping("/register")
    public String register(){
        return "employee/register";
    }

    @GetMapping("/list")
    public  String list(){
        return "employee/list";
    }
}
