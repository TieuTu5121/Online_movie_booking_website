package com.example.nedcinema.repository;

import com.example.nedcinema.entity.SeatNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatNumberRepository extends JpaRepository<SeatNumber, Integer> {
    List<SeatNumber> findBySeatList(int seatListId);
}

