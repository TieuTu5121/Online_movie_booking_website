package com.example.nedcinema.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "seatnumber")
@AllArgsConstructor
public class SeatNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Number", nullable = false)
    private int number;

    @Column(name = "Status", nullable = false)
    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SeatlistId",nullable = false)
    private SeatList seatList;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoomId",nullable = false)
    private Rooms rooms;
    // Constructors, getters, setters
    public SeatNumber(){

    }

    public SeatNumber(int number, boolean status,Rooms rooms, SeatList seatList) {
        this.number = number;
        this.status = status;
        this.rooms = rooms;
        this.seatList = seatList;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public SeatList getSeatList() {
        return seatList;
    }

    public void setSeatList(SeatList seatList) {
        this.seatList = seatList;
    }

    public void setSeatListId(int seatListId) {
    }
}