package com.example.lecpractice.controllers;

import com.example.lecpractice.dto.WeatherResponse;
import com.example.lecpractice.mapper.WeatherServiceMapper;
import com.example.lecpractice.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController {
    @Autowired
    WeatherService weatherService;

    @GetMapping("/weather")
    public String getWeather(Model model) {
        model.addAttribute("weatherResponse", weatherService.weatherResponse());
        return "weatherView";
    }

}
