package com.example.nedcinema.Impl;

import com.example.nedcinema.Exception.NotFoundException;
import com.example.nedcinema.entity.Rooms;
import com.example.nedcinema.repository.RoomsRepository;
import com.example.nedcinema.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomsServiceImpl implements RoomsService {
    @Autowired
    RoomsRepository roomsRepository;

    @Override
    public Rooms createRoom(Rooms rooms) {
        return roomsRepository.save(rooms);
    }

    @Override
    public Rooms updateRoom(int id, Rooms rooms) {
        Optional<Rooms> existing = roomsRepository.findById(id);
        if (existing.isPresent()) {
            Rooms rooms1 = existing.get();
            rooms1.setName(rooms.getName());
            rooms1.setSeats(rooms.getSeats());
            rooms1.setCinema(rooms.getCinema());
            return roomsRepository.save(rooms1);
        } else {
            throw new NotFoundException("Not found Room with id :" + id);
        }

    }

    @Override
    public void deleteRoom(int id) {
        try {
            Optional<Rooms> rooms = roomsRepository.findById(id);
            roomsRepository.deleteById(id);
        } catch (NotFoundException notFoundException) {
            throw new NotFoundException("Not found Room with id :" + id);
        }
    }

    @Override
    public Rooms getRoom(int id) {
        Optional<Rooms> existingRooms = roomsRepository.findById(id);
        if (existingRooms.isPresent()) {
            Rooms rooms = existingRooms.get();
            return rooms;
        } else {
            throw new NotFoundException("Not found Room with id :" + id);
        }
    }

    @Override
    public List<Rooms> getRooms() {
        return roomsRepository.findAll();
    }

    @Override
    public List<Rooms> getRoomsByCinema(int cinemaId) {
        return roomsRepository.findByCinemaId(cinemaId);
    }

}
