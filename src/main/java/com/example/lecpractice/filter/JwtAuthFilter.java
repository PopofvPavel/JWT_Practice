package com.example.lecpractice.filter;

import com.example.lecpractice.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthFilter {
    @Autowired
    JwtService jwtService;


}
