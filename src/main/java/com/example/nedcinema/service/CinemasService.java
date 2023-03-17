package com.example.nedcinema.service;

import com.example.nedcinema.entity.Cinemas;

import java.util.List;

public interface CinemasService {
    Cinemas addCinema(Cinemas cinema);
    Cinemas updateCinema(int cinemaId, Cinemas cinema);
    void deleteCinema(int cinemaId);
    Cinemas getCinema(int cinemaId);
    List<Cinemas> getAllCinemas();
}
