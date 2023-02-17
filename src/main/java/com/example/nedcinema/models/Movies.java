package com.example.nedcinema.models;

import java.sql.Timestamp;

public class Movies {

    private int id;
    private String maphim;
    private String title;
    private String year;
    private String  rated;

    private String released;

    private String  runtime;
    private String geners;
    private String directors;
    private String actors;
    private String  plot;
    private String language;
    private String poster;
    private String banner;
    private String trailer;
    private Cinema cinema;
    private Timestamp createdAt;
    private Timestamp updateAt;

    public Movies(String maphim, String title, String year, String rated, String released, String runtime, String geners, String directors, String actors, String plot, String language, String poster, String banner, String trailer, Cinema cinema, Timestamp createdAt, Timestamp updateAt) {
        this.maphim = maphim;
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.geners = geners;
        this.directors = directors;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.poster = poster;
        this.banner = banner;
        this.trailer = trailer;
        this.cinema = cinema;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public String getMaphim() {
        return maphim;
    }

    public void setMaphim(String maphim) {
        this.maphim = maphim;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGeners() {
        return geners;
    }

    public void setGeners(String geners) {
        this.geners = geners;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }
}
