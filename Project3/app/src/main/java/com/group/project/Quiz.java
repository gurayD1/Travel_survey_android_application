package com.group.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Quiz {

    public ArrayList<String> filterCountries(ResultModel result) {
        CountryDB countryDB = new CountryDB();
        String userClimate = result.getClimate();
        ArrayList<String> countryList = new ArrayList<String>();

        for (CountryModel country : countryDB.GetAllCountries()) {
            String name = country.getCountry();
            String climate = country.getClimate();
            if (userClimate.equals(climate)) {
                countryList.add(name);
            }
        }

        return countryList;
    }

    public ArrayList<String> filterClimate(ResultModel result) {
        CityDB cityDB = new CityDB();
        ArrayList<String> cityList = new ArrayList<String>();
        ArrayList<String> countryList = filterCountries(result);

        // Add city if climate of country matches what user selected
        for (CityModel city : cityDB.GetAllCities()) {
            if (countryList.contains(city.getCountry())) {
                cityList.add(city.getName());
            }
        }
        return cityList;
    }

    public ArrayList<ScoreModel> calculateScores(ResultModel result) {
        CityDB cityDB = new CityDB();
        String userBudget = result.getBudget();
        String userPhobia = result.getPhobia();
        String userLandscape = result.getLandscape();
        ArrayList<ScoreModel> scoreList = new ArrayList<ScoreModel>();

        for (CityModel city : cityDB.GetAllCities()) {
            boolean addCity = false;
            int score = 0;

            // If person is rich, add all city options to list, none are filtered
            if (userBudget.equals("Rich") &&
                    (city.getBudget().equals("Mid") || city.getBudget().equals("Cheap"))) {
                addCity = true;
                score++;
            }
            // If person chooses mid, add mid and cheap cities to list only
            else if (userBudget.equals("Mid") && city.getBudget().equals("Cheap")) {
                addCity = true;
                score++;
            }
            // Otherwise if they choose cheap, only cheap will be added to list
            else if (city.getBudget().equals(userBudget)) {
                addCity = true;
                score++;
            }

            if (city.getPhobia().equals("None")) {
                addCity = true;
                score++;
            }
            else if (!city.getPhobia().equals(userPhobia)) {
                addCity = true;
                score++;
            }

            if (city.getLandscape().equals(userLandscape)) {
                addCity = true;
                score++;
            }

            if (addCity == true) {
                ScoreModel scoreModel = new ScoreModel(city, score);
                scoreList.add(scoreModel);
            }
        }

        return scoreList;
    }

    public ArrayList<String> filterCities(ResultModel result) {
        // Get the possible cities
        ArrayList<ScoreModel> scoreList = calculateScores(result);
        Collections.sort(scoreList);

        ArrayList<String> cityListByClimate = filterClimate(result);
        ArrayList<ScoreModel> filteredScoreList = new ArrayList<ScoreModel>();
        ArrayList<String> cityList = new ArrayList<String>();

        for (ScoreModel scoreModel : scoreList) {
            if (cityListByClimate.contains(scoreModel.getCity().getName())) {
                ScoreModel newModel = new ScoreModel(scoreModel.getCity(), scoreModel.getScore());
                filteredScoreList.add(newModel);
            }
        }

        for (ScoreModel scoreModel : filteredScoreList) {
            if (scoreModel.getScore() > 1) {
                cityList.add(scoreModel.getCity().getName());
            }
        }

        return cityList;
    }

    public ArrayList<String> getCountriesFromCities(ResultModel result) {
        // Create city DB
        CityDB cityDB = new CityDB();
        CityModel[] allCities = cityDB.GetAllCities();

        // Filter cities
        ArrayList<String> cityList = filterCities(result);
        Set<String> countrySet = new HashSet<String>();

        // Get countries
        for (CityModel city : allCities) {
            if (cityList.contains(city.getName())) {
                countrySet.add(city.getCountry());
            }
        }

        ArrayList<String> countryList = new ArrayList<String>(countrySet);

        return countryList;
    }

    public ArrayList<CityModel> getFinalCities(ResultModel result) {
        // Create city DB
        CityDB cityDB = new CityDB();
        CityModel[] allCities = cityDB.GetAllCities();

        // Filter cities
        ArrayList<String> cityList = filterCities(result);
        Set<String> citySet = new HashSet<String>();
        String userCountry = result.getCountryName();

        // Get cities
        for (CityModel city : allCities) {
            if (cityList.contains(city.getName()) && city.getCountry().equals(userCountry)) {
                citySet.add(city.getName());
            }
        }

        ArrayList<String> filteredNames = new ArrayList<String>(citySet);
        ArrayList<CityModel> finalCities = new ArrayList<CityModel>();

        // Add the list of filtered city models to a new array list
        for (String city : filteredNames) {
            // Get city from database
            finalCities.add(cityDB.GetCity(city));
        }

        return finalCities;
    }

}
