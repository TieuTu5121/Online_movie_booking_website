package com.example.nedcinema.Impl;

import com.example.nedcinema.Exception.*;
import com.example.nedcinema.entity.Showtime;
import com.example.nedcinema.repository.ShowtimesRepository;
import com.example.nedcinema.service.ShowtimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowtimesServiceImpl implements ShowtimesService {

    @Autowired
    private ShowtimesRepository showtimesRepository;

    @Override
    public Showtime createShowtimes(Showtime showtime) {

        return showtimesRepository.save(showtime);
    }

    @Override
    public void deleteShowtimes(int id) {
        try {
            Optional<Showtime> existingShowtimes = showtimesRepository.findById(id);
            if (!existingShowtimes.isPresent()) {
                throw new NotFoundException("Showtimes with id " + id + " does not exist");
            }
            showtimesRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new BadRequestException("Showtimes with id " + id + " is associated with other entities");
        }
    }

    @Override
    public Showtime updateShowtimes(int id, Showtime showtime) {
        Optional<Showtime> existingShowtimes = showtimesRepository.findById(id);
        if (!existingShowtimes.isPresent()) {
            throw new NotFoundException("Showtimes with id " + id + " does not exist");
        }
        return showtimesRepository.save(showtime);
    }

    @Override
    public Showtime getShowtimes(int id) {
        Optional<Showtime> existingShowtimes = showtimesRepository.findById(id);
        if (!existingShowtimes.isPresent()) {
            throw new NotFoundException("Showtimes with id " + id + " does not exist");
        }
        return existingShowtimes.get();
    }

    @Override
    public List<Showtime> getAllShowtimes() {
        return showtimesRepository.findAllByOrderByCreatedAtAsc();
    }

    @Override
    public List<Showtime> getAllShowtimesByCinema(int cinemaId) {
        return showtimesRepository.findAllByCinemaId(cinemaId);
    }

}

