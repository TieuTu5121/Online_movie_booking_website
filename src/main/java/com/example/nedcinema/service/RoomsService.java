package com.example.nedcinema.service;

import com.example.nedcinema.entity.Rooms;

import java.util.List;

public interface RoomsService {
    Rooms createRoom(Rooms rooms);

    Rooms updateRoom(int id, Rooms rooms);

    void deleteRoom(int id);

    Rooms getRoom(int id);

    List<Rooms> getRooms();

    List<Rooms> getRoomsByCinema(int cinemaId);
}
