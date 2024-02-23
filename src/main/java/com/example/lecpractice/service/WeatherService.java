package com.example.lecpractice.service;

import com.example.lecpractice.dto.WeatherResponse;
import com.example.lecpractice.mapper.WeatherServiceMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    public static String HTTPS_API_TOMORROW = "https://api.tomorrow.io/v4/weather/forecast";
    public static final String LOCATION = "42.3478, -71.0466";
    public static final String APIKEY = "ot46q5SWnylVS8NOcP0eJbxnRvbJhAdQ";

    private RestTemplate restTemplate;
    private final WeatherServiceMapper weatherServiceMapper;

    public WeatherService(WeatherServiceMapper weatherServiceMapper) {
        this.weatherServiceMapper = weatherServiceMapper;
        this.restTemplate = new RestTemplate();
    }

    public WeatherResponse weatherResponse() {
    //public String weatherResponse() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                HTTPS_API_TOMORROW + "?location=" + LOCATION + "&apikey=" + APIKEY, String.class);
        //eturn responseEntity.getBody();
        return weatherServiceMapper.mapWeatherResponse(responseEntity.getBody());

    }

}
