package com.group.project;

import androidx.annotation.DrawableRes;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResultModel implements Serializable {
    @SerializedName("Id")
    private int Id;
    @SerializedName("climate")
    private String climate;
    @SerializedName("phobia")
    private String phobia;
    @SerializedName("landscape")
    private String landscape;
    @SerializedName("budget")
    private String budget;
    @SerializedName("countryName")
    private String countryName;
    @SerializedName("cityName")
    private String cityName;
    @SerializedName("userName")
    private String userName;
    @SerializedName("description")
    private String description;
    @SerializedName("image")
    @DrawableRes private int image;

    public ResultModel() {
        Id = ResultsDB.getInstance().getID();
    }


    // Getters and setters
    public String getClimate() {
        return climate;
    }

    public String getPhobia() {
        return phobia;
    }

    public String getLandscape() {
        return landscape;
    }

    public String getBudget() {
        return budget;
    }

    public Integer getId() {
        return Id;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public String getUserName() {
        return userName;
    }

    public String getDescription() { return description; }

    public @DrawableRes int getImage() {
        return image;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public void setCountryName(String name) {
        this.countryName = name;
    }

    public void setCityName(String name) {
        this.cityName = name;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public void setPhobia(String phobia) {
        this.phobia = phobia;
    }

    public void setLandscape(String landscape) {
        this.landscape = landscape;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }


}
