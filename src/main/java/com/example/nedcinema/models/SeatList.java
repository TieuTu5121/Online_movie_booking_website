package com.example.nedcinema.models;

public class SeatList {

    private int id;
    private String seatName;
    private String  type;
    private int price;
    private Cinema cinema;

    public SeatList(String seatName, String type, int price, Cinema cinema) {
        this.seatName = seatName;
        this.type = type;
        this.price = price;
        this.cinema = cinema;
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

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public String toString() {
        return "SeatList{" +
                "id=" + id +
                ", seatName='" + seatName + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", cinema=" + cinema +
                '}';
    }
}
