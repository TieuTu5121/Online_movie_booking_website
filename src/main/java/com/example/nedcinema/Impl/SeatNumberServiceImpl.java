package com.example.nedcinema.Impl;

import com.example.nedcinema.Exception.NotFoundException;
import com.example.nedcinema.entity.SeatNumber;
import com.example.nedcinema.repository.SeatNumberRepository;
import com.example.nedcinema.service.SeatNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SeatNumberServiceImpl implements SeatNumberService {

    @Autowired
    private SeatNumberRepository seatNumberRepository;

    @Override
    public SeatNumber createSeatNumber(SeatNumber seatNumber) {
        return seatNumberRepository.save(seatNumber);
    }

    @Override
    public void deleteSeatNumber(int id) {
        seatNumberRepository.deleteById(id);
    }

    @Override
    public SeatNumber updateSeatNumber(int id, SeatNumber seatNumber) {

        return seatNumberRepository.save(seatNumber);
    }



    @Override
    public List<SeatNumber> getAvailableSeatNumbersBySeatList(int seatListId) {
        try {
            List<SeatNumber> seatNumbers = seatNumberRepository.findBySeatList(seatListId);
            List<SeatNumber> availableSeatNumbers = new ArrayList<>();
            for (SeatNumber seatNumber : seatNumbers) {
                if (!seatNumber.getStatus()) {
                    availableSeatNumbers.add(seatNumber);
                }
            }
            return availableSeatNumbers;
        }catch (NotFoundException notFoundException){
            throw new NotFoundException("Không tìm thấy SeatList id: "+ seatListId);

        }
    }


    @Override
    public SeatNumber getSeatNumber(int id) {
        Optional<SeatNumber> result = seatNumberRepository.findById(id);
        return result.orElseThrow(() -> new NotFoundException("Không tìm thấy ghế có ID = " + id));
    }
}
