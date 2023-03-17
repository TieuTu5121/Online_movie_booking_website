package com.example.nedcinema.entity;

import jakarta.persistence.*;

@Entity
@Table(name="seatlist")
public class SeatList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private int id;
    @Column(name = "SeatName",nullable = false,unique = true)
    private String seatName;
    @Column(name = "Type",nullable = false)

    private String  type;
    @Column(name = "Price",nullable = false)
    private int price;

    public SeatList(){

    }
    public SeatList(int id, String seatName, String type, int price) {
        this.id = id;
        this.seatName = seatName;
        this.type = type;
        this.price = price;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
