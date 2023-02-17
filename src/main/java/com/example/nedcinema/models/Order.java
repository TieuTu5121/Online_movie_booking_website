package com.example.nedcinema.models;

import java.util.Date;
import java.util.Stack;

public class Order {

    private int id;
    private User user;
    private Movies movies;
    private Cinema cinema;
    private Showtimes showtimes;
    private Food food;
    private SeatNumber seatNumber;
    private String date;
    private String time;
    private int price;
    private String status;
    private Date creatAt;
    private Date updateAt;

    public Order(User user, Movies movies, Cinema cinema, Showtimes showtimes, Food food, SeatNumber seatNumber, String date, String time, int price, String status, Date creatAt, Date updateAt) {
        this.user = user;
        this.movies = movies;
        this.cinema = cinema;
        this.showtimes = showtimes;
        this.food = food;
        this.seatNumber = seatNumber;
        this.date = date;
        this.time = time;
        this.price = price;
        this.status = status;
        this.creatAt = creatAt;
        this.updateAt = updateAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Showtimes getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(Showtimes showtimes) {
        this.showtimes = showtimes;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public SeatNumber getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(SeatNumber seatNumber) {
        this.seatNumber = seatNumber;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Date creatAt) {
        this.creatAt = creatAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
