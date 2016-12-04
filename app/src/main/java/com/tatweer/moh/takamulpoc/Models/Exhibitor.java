package com.tatweer.moh.takamulpoc.Models;

/**
 * Created by moh on 11/17/2016.
 */

public class Exhibitor {
    String name;
    int image;
    String country;
    String stageNumber;

    public Exhibitor(String name, int image, String country, String stageNumber)
    {
        this.name = name;
        this.image = image;
        this.country = country;
        this.stageNumber = stageNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStageNumber() {
        return stageNumber;
    }

    public void setStageNumber(String stageNumber) {
        this.stageNumber = stageNumber;
    }
}
