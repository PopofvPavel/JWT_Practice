package com.example.lecpractice.mapper;

import com.example.lecpractice.dto.Location;
import com.example.lecpractice.dto.WeatherResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherServiceMapper {
    private final ObjectMapper jsonParser = new ObjectMapper();

    @SneakyThrows
    public WeatherResponse mapWeatherResponse(String string) {
        JsonNode jsonNode = jsonParser.readTree(string);
        return new WeatherResponse(
                getLocation(jsonNode),
                getAvgTemperatures(jsonNode, "minutely", "temperature"),
                getAvgTemperatures(jsonNode, "hourly", "temperature"),
                getAvgTemperatures(jsonNode, "daily", "temperatureApparentAvg")
        );
    }

    private Location getLocation(JsonNode jsonNode) {
        JsonNode locationNode = jsonNode.get("location");
        String latitude = String.valueOf(locationNode.get("lat"));
        String longitude = String.valueOf(locationNode.get("lon"));
        return new Location(latitude, longitude);
    }

    private double getAvgTemperatures(JsonNode jsonNode, String range, String nodeName) {
        return jsonNode.get("timelines")
                .get(range)
                .findValues(nodeName)
                .stream()
                .mapToDouble(x -> Double.parseDouble(x.asText())).average().getAsDouble();

    }


}
