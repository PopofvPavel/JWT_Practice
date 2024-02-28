package com.example.lecpractice.controllers;

import com.example.lecpractice.dto.WeatherResponse;
import com.example.lecpractice.mapper.WeatherServiceMapper;
import com.example.lecpractice.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InfoController {
    @Autowired
    WeatherService weatherService;

    @GetMapping("/weather")
    @ResponseBody
    public WeatherResponse getWeather() {
        return weatherService.weatherResponse();
    }

}
