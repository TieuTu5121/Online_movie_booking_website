package com.example.nedcinema.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
@Table(name ="cinemas")
public class Cinema {
    @Id
    @Column(name="_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="Name",nullable = false)
    private String  name;

    @Column(name="Seats",nullable = false)
    private int seats;
    public Cinema(){

    }
    public Cinema(String name, int seats) {
        this.name = name;
        this.seats = seats;
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
    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seats=" + seats +
                '}';
    }
}

