package com.example.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Spring MVC
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";     //hello.html을 사용하겠다(.html을 생략) -> thymeleaf라이브러리 사용하기 위해서
    }

}
