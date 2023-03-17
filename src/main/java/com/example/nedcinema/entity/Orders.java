package com.example.nedcinema.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserUID",nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MovieID",nullable = false)
    private Movies movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CinemaID")
    private Cinemas cinema;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShowTimesID")
    private Showtime showtime;
    @OneToOne
    @JoinColumn(name="order_item",nullable = false)
    private OrderItem orderItem;

    @Column(name = "date",nullable = false)
    private String date;

    @Column(name = "time",nullable = false)
    private String time;

    @Column(name = "price",nullable = false)
    private int price;

    @Column(name = "status",nullable = false)
    private String status;

    @Column(name = "created_at",nullable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_at",nullable = false)
    @UpdateTimestamp
    private Timestamp updatedAt;


    // Getters and Setters

    public Orders() {
    }

    public Orders(User user, Movies movie, Cinemas cinema, OrderItem orderItem,Showtime showtime, String date, String time, int price, String status, Timestamp createdAt, Timestamp updatedAt) {
        this.user = user;
        this.movie = movie;
        this.cinema = cinema;
        this.showtime = showtime;
        this.orderItem = orderItem;
        this.date = date;
        this.time = time;
        this.price = price;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }

    public Cinemas getCinema() {
        return cinema;
    }

    public void setCinema(Cinemas cinema) {
        this.cinema = cinema;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }



}