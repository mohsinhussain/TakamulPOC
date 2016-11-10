package com.tatweer.moh.takamulpoc.Models;

/**
 * Created by moh on 11/9/2016.
 */

public class Invention {
    private String name;
    private String detail;
    private int thumbnail;
    private String category;
    private int daysToGo;
    private int progress;
    private int backers;


    public Invention() {
    }

    public Invention(String name, String detail, int thumbnail, String category, int daysToGo, int progress, int backers) {
        this.name = name;
        this.detail = detail;
        this.thumbnail = thumbnail;
        this.category = category;
        this.daysToGo = daysToGo;
        this.progress = progress;
        this.backers = backers;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDaysToGo() {
        return daysToGo;
    }

    public void setDaysToGo(int daysToGo) {
        this.daysToGo = daysToGo;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getBackers() {
        return backers;
    }

    public void setBackers(int backers) {
        this.backers = backers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
