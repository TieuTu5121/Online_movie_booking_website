package com.example.nedcinema.Impl;

import com.example.nedcinema.entity.Cinemas;
import com.example.nedcinema.repository.CinemasRepository;
import com.example.nedcinema.service.CinemasService;
import com.example.nedcinema.Exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemasServiceImpl implements CinemasService {

    @Autowired
    private CinemasRepository cinemasRepository;

    @Override
    @Transactional
    public Cinemas addCinema(Cinemas cinema) {
        return cinemasRepository.save(cinema);
    }

    @Override
    @Transactional
    public Cinemas updateCinema(int cinemaId, Cinemas cinema) {
        try {
            Optional<Cinemas> optionalExistingCinema = cinemasRepository.findById(cinemaId);
            Cinemas existingCinema = optionalExistingCinema.get();
            existingCinema.setName(cinema.getName());
            existingCinema.setAddress(cinema.getAddress());
            return cinemasRepository.save(existingCinema);
        } catch (Exception e) {
            // Xử lý lỗi
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteCinema(int cinemaId) {
        cinemasRepository.deleteById(cinemaId);
    }

    @Override
    public Cinemas getCinema(int cinemaId) {
        Optional<Cinemas> optionalCinema = cinemasRepository.findById(cinemaId);
        if (optionalCinema.isPresent()) {
            return optionalCinema.get();
        } else {
            throw new NotFoundException("Cinema not found with id: " + cinemaId);
        }
    }

    @Override
    public List<Cinemas> getAllCinemas() {
        return cinemasRepository.findAll();
    }
}
