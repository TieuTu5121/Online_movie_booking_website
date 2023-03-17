package com.example.nedcinema.repository;

import com.example.nedcinema.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowtimesRepository extends JpaRepository<Showtime, Integer> {

    List<Showtime> findAllByOrderByCreatedAtAsc();

    List<Showtime> findAllByCinemaId(int cinemaId);

}
