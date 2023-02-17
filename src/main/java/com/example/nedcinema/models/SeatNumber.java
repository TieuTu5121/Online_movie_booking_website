package com.example.nedcinema.models;

public class SeatNumber {

    private int id;
    private int numder;
    private String status;
    private SeatList seatList;

    public SeatNumber(int numder, String status, SeatList seatList) {
        this.numder = numder;
        this.status = status;
        this.seatList = seatList;
    }

    public int getNumder() {
        return numder;
    }

    public void setNumder(int numder) {
        this.numder = numder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SeatList getSeatList() {
        return seatList;
    }

    public void setSeatList(SeatList seatList) {
        this.seatList = seatList;
    }
}
