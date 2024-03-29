package com.example.lecpractice.dto;

public class Location {
    private String latitude;
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Location(String latitude, String longtitude) {
        this.latitude = latitude;
        this.longitude = longtitude;
    }
}
