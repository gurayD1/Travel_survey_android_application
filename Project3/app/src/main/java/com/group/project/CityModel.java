package com.group.project;

import androidx.annotation.DrawableRes;

import java.io.Serializable;

public class CityModel implements Serializable {

    private String name;
    private String country;
    private String description;
    private String latitude;
    private String longitude;
    private String budget;
    private String phobia;
    private String landscape;
    private String url;

    @DrawableRes
    private int image;

    public CityModel(String name, String country, String description, String latitude, String longitude,
                     String budget, String phobia, String landscape,
                     String url, @DrawableRes int image) {
        this.name = name;
        this.country = country;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.budget = budget;
        this.phobia = phobia;
        this.landscape = landscape;
        this.url = url;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return description;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getBudget() {
        return budget;
    }

    public String getPhobia() {
        return phobia;
    }

    public String getLandscape() {
        return landscape;
    }

    public String url() {
        return url;
    }

    @DrawableRes
    public int getImage() {
        return image;
    }

}
