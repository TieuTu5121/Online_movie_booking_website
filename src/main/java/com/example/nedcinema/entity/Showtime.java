package com.example.nedcinema.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;


@Entity
@Table(name = "showtime")
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private String date;

    @Column(name = "time",nullable = false)
    private String time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinemaId",nullable = false)
    private Cinemas cinema;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @CreationTimestamp
    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;


    public Showtime() {}

    public Showtime(String date, String time, Cinemas cinema) {
        this.date = date;
        this.time = time;
        this.cinema = cinema;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Cinemas getCinema() {
        return cinema;
    }

    public void setCinema(Cinemas cinema) {
        this.cinema = cinema;
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
