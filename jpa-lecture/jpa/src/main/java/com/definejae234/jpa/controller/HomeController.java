package com.definejae234.jpa.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"/", "/index", "/main", "/home"})
    public String index() {
        return "index/index";
    }
}
