package com.example.nedcinema.service;

import com.example.nedcinema.entity.Showtime;

import java.util.List;


public interface ShowtimesService {

    Showtime createShowtimes(Showtime showtime);

    void deleteShowtimes(int id);

    Showtime updateShowtimes(int id, Showtime showtime);

    Showtime getShowtimes(int id);

    List<Showtime> getAllShowtimes();

    List<Showtime> getAllShowtimesByCinema(int cinemaId);

}


