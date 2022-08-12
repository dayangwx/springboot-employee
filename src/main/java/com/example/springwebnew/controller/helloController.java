package com.example.springwebnew.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class helloController {
    @GetMapping({"/","/index"})
    public String test(Model model){
        return "index";
    }
}
