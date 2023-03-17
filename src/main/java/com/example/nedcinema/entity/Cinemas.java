package com.example.nedcinema.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Table(name ="cinemas")
public class Cinemas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="Name",nullable = false)
    private String  name;

    @Column(name = "Address",nullable = false)
    private String address;

    public Cinemas(){

    }

    public Cinemas(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}

