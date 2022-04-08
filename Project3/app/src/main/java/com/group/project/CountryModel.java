package com.group.project;

import java.io.Serializable;

public class CountryModel implements Serializable {

    private String name;
    private String climate;

    public CountryModel(String name, String climate) {
        this.name = name;
        this.climate = climate;
    }

    public String getCountry() {
        return name;
    }

    public String getClimate() {
        return climate;
    }
}
