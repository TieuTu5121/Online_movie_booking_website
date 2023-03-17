package com.example.nedcinema.service;

import com.example.nedcinema.entity.SeatList;

import java.util.List;

public interface SeatlistService {
    SeatList createSeatlist(SeatList seatList);
    void deleteSeatlist(int id);
    SeatList updateSeatlist(int id,SeatList seatList);
    SeatList updatePrice(int id,int price);
    SeatList getSeatlist(int id);
    List<SeatList> getAllSeatlist();
}
