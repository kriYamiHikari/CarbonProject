package com.example.carbonproject.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MusicInfoAll {
    private int id;
    private String title;
    private String artist;
    private String language;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseTime;
    private String transname;
    private String album;
    private double gain;
    private double peak;
    private double lra;
    private double bpm;
    private double interval;
    private String company;
    private String genre;

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

    public String getTransname() {
        return transname;
    }

    public void setTransname(String transname) {
        this.transname = transname;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public double getGain() {
        return gain;
    }

    public void setGain(double gain) {
        this.gain = gain;
    }

    public double getPeak() {
        return peak;
    }

    public void setPeak(double peak) {
        this.peak = peak;
    }

    public double getLra() {
        return lra;
    }

    public void setLra(double lra) {
        this.lra = lra;
    }

    public double getBpm() {
        return bpm;
    }

    public void setBpm(double bpm) {
        this.bpm = bpm;
    }

    public double getInterval() {
        return interval;
    }

    public void setInterval(double interval) {
        this.interval = interval;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
