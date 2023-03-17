package com.example.nedcinema.Impl;

import com.example.nedcinema.Exception.NotFoundException;
import com.example.nedcinema.entity.SeatList;
import com.example.nedcinema.repository.SeatListRepository;
import com.example.nedcinema.service.SeatlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SeatlistServiceImpl implements SeatlistService {
    @Autowired
    SeatListRepository seatListRepository;

    @Override
    public SeatList createSeatlist(SeatList seatList) {
        return seatListRepository.save(seatList);
    }

    @Override
    public void deleteSeatlist(int id) {
        Optional<SeatList> existingSL = seatListRepository.findById(id);
        if (existingSL.isEmpty()) {
            throw new NotFoundException("Không tồn tại " + id);
        }
        seatListRepository.deleteById(id);
    }

    @Override
    public SeatList updateSeatlist(int id, SeatList seatList) {
        Optional<SeatList> existingSL = seatListRepository.findById(id);
        if (existingSL.isEmpty()) {
            throw new NotFoundException("Không tồn tại " + id);
        }
        return seatListRepository.save(seatList);
    }

    @Override
    public SeatList updatePrice(int id, int price) {
        Optional<SeatList> existingSL = seatListRepository.findById(id);
        if (existingSL.isEmpty()) {
            throw new NotFoundException("Không tồn tại " + id);
        }
        SeatList seatList = existingSL.get();
        seatList.setPrice(price);
        return seatListRepository.save(seatList);
    }

    @Override
    public SeatList getSeatlist(int id) {
        Optional<SeatList> existingSL = seatListRepository.findById(id);
        if (existingSL.isEmpty()) {
            throw new NotFoundException("Không tồn tại " + id);
        }
        return existingSL.get();
    }

    @Override
    public List<SeatList> getAllSeatlist() {
        return seatListRepository.findAll();
    }
}
