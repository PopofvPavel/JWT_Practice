package com.example.lecpractice.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class PracticeController {
    private final String apiUrl = "https://api.tomorrow.io/v4/weather/forecast?location=42.3478,-71.0466&apikey=ot46q5SWnylVS8NOcP0eJbxnRvbJhAd";
    private final String token = "ot46q5SWnylVS8NOcP0eJbxnRvbJhAdQ";

    private final RestTemplate restTemplate = new RestTemplate();
    @GetMapping("/prac")
    public void sendRequestToApi() {
            ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
            System.out.println( response.getBody());
        }

    }

