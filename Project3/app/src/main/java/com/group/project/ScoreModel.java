package com.group.project;

import androidx.annotation.DrawableRes;

public class ScoreModel implements Comparable<ScoreModel>{

    private CityModel city;
    private int score;

    public ScoreModel(CityModel city, int score) {
        this.city = city;
        this.score = score;
    }

    public CityModel getCity() { return city; }

    public int getScore() { return score; }

    @Override
    public int compareTo(ScoreModel scoreModel) {
        return this.getScore() - scoreModel.getScore();
    }
}
