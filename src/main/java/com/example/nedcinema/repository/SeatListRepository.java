package com.example.nedcinema.repository;

import com.example.nedcinema.entity.SeatList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatListRepository extends JpaRepository<SeatList,Integer> {
}
