package com.example.carbonproject.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MusicInfo {
    private int id;
    private String title;
    private String artist;
    private String language;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (this.releaseTime == null) {
            return null;
        }
        return sdf.format(this.releaseTime);
    }

    public void setReleaseTime(String releaseTime) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            this.releaseTime = sdf.parse(releaseTime);
        } catch (ParseException e) {
            this.releaseTime = null;
        }
    }
}
