package com.example.lecpractice.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SberController {
    @GetMapping("/sber")
    public String getRequest() {
        return "This is sber controller return string";
    }
}
