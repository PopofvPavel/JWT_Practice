package com.example.lecpractice.dto;

import lombok.Data;

@Data
public class WeatherResponse {

    private final Location location;
    private final double avgTempMin;
    private final double avgTempHour;
    private final double avgTempDay;



}
