package com.definejae234.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PracticeController {

    @GetMapping({"/main", "/"})
    @ResponseBody
    public String mainPage() {
        return "main page";
    }

}
