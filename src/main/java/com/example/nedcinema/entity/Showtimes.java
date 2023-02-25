package com.example.nedcinema.entity;

import java.util.Date;

public class Showtimes {

    private int id;
    private String date;
    private String time;
    private Cinema cinema;
    private Date createdAt;
    private Date updateAt;

    public Showtimes(String date, String time, Cinema cinema, Date createdAt, Date updateAt) {
        this.date = date;
        this.time = time;
        this.cinema = cinema;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
