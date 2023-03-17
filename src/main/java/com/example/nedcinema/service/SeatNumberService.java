package com.example.nedcinema.service;

import com.example.nedcinema.entity.SeatNumber;

import java.util.List;

public interface SeatNumberService {
    SeatNumber createSeatNumber(SeatNumber seatNumber);
    void deleteSeatNumber(int id);
    SeatNumber updateSeatNumber(int id, SeatNumber seatNumber);

    List<SeatNumber> getAvailableSeatNumbersBySeatList(int seatListId);
    SeatNumber getSeatNumber(int id);
}
