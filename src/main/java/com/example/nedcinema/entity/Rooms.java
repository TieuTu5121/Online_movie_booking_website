package com.example.nedcinema.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Room")
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "seats",nullable = false)
    private int seats;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinemaID",nullable = false)
    private Cinemas cinema;

    public Rooms(){

    }
    public Rooms(int id, int seats, Cinemas cinema) {
        this.id = id;
        this.seats = seats;
        this.cinema = cinema;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Cinemas getCinema() {
        return cinema;
    }

    public void setCinema(Cinemas cinema) {
        this.cinema = cinema;
    }
}
