package com.example.nedcinema.repository;

import com.example.nedcinema.entity.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Integer> {
    List<Rooms> findByCinemaId(int cinemaId);
}
