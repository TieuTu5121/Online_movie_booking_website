package com.example.nedcinema.repository;

import com.example.nedcinema.entity.Cinemas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemasRepository extends JpaRepository<Cinemas,Integer> {
}
