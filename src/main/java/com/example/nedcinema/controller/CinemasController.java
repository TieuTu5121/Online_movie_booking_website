package com.example.nedcinema.controller;


import com.example.nedcinema.Exception.NotFoundException;
import com.example.nedcinema.Impl.SeatlistServiceImpl;
import com.example.nedcinema.entity.Cinemas;
import com.example.nedcinema.entity.Rooms;
import com.example.nedcinema.entity.SeatList;
import com.example.nedcinema.entity.SeatNumber;
import com.example.nedcinema.service.CinemasService;
import com.example.nedcinema.service.RoomsService;
import com.example.nedcinema.service.SeatlistService;
import com.example.nedcinema.service.SeatNumberService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/cinemas")
public class CinemasController {
    @Autowired
    private CinemasService cinemasService;

    @Autowired
    private RoomsService roomsService;
    @Autowired
    private  SeatlistServiceImpl seatlistService;
    @Autowired
    private SeatNumberService seatNumberService;

    @PostMapping
    public ResponseEntity<Cinemas> addCinema(@RequestBody Cinemas cinema) {
        Cinemas addedCinema = cinemasService.addCinema(cinema);
        return new ResponseEntity<>(addedCinema, HttpStatus.CREATED);
    }

    @PutMapping("/{cinemaId}")
    public ResponseEntity<Cinemas> updateCinema(@PathVariable int cinemaId, @RequestBody Cinemas cinema) {
        Cinemas updatedCinema = cinemasService.updateCinema(cinemaId, cinema);
        return new ResponseEntity<>(updatedCinema, HttpStatus.OK);
    }

    @DeleteMapping("/{cinemaId}")
    public ResponseEntity<Void> deleteCinema(@PathVariable int cinemaId) {
        cinemasService.deleteCinema(cinemaId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{cinemaId}")
    public ResponseEntity<Cinemas> getCinema(@PathVariable int cinemaId) {
        Cinemas cinema = cinemasService.getCinema(cinemaId);
        return new ResponseEntity<>(cinema, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Cinemas>> getAllCinemas() {
        List<Cinemas> cinemas = cinemasService.getAllCinemas();
        return new ResponseEntity<>(cinemas, HttpStatus.OK);
    }

    @GetMapping("/{cinemaId}/rooms")
    public ResponseEntity<List<Rooms>> getRoomsByCinemaId(@PathVariable int cinemaId) {
        try{
            List<Rooms> rooms = roomsService.getRoomsByCinema(cinemaId);

            return new ResponseEntity<>(rooms, HttpStatus.OK);
        }catch (NotFoundException notFoundException){
            throw new NotFoundException("Lỗi không tìm thấy");
        }
    }


    @GetMapping("/{cinemaId}/rooms/{roomId}")
    public ResponseEntity<Rooms> getRoomByCinema(@PathVariable int cinemaId, @PathVariable int roomId) {
        Cinemas cinemas = cinemasService.getCinema(cinemaId);
        Rooms rooms = roomsService.getRoom(roomId);
        if (rooms.getCinema().getId() != cinemas.getId()) {
            throw new NotFoundException("Room not found with id " + roomId + " in cinema with id " + cinemaId);
        }
        return ResponseEntity.ok().body(rooms);
    }
//    @GetMapping("/rooms")
//    public List<Rooms> getRooms(){
//        List<Rooms> rooms =  roomsService.getRooms();
//        return rooms;
//    }


    @PostMapping("/{cinemaId}/rooms")
    public ResponseEntity<Rooms> addRoom(@PathVariable int cinemaId, @RequestBody Rooms rooms) {
        Cinemas cinemas = cinemasService.getCinema(cinemaId);
        rooms.setCinema(cinemas);
        Rooms newRoom = roomsService.createRoom(rooms);
        return ResponseEntity.ok().body(newRoom);
    }

    @PutMapping("/{cinemaId}/rooms/{roomId}")
    public ResponseEntity<Rooms> updateRoom(@PathVariable int cinemaId, @PathVariable int roomId, @RequestBody Rooms rooms) {
        Cinemas cinemas = cinemasService.getCinema(cinemaId);
        Rooms existingRoom = roomsService.getRoom(roomId);
        if (existingRoom.getCinema().getId() != cinemas.getId()) {
            throw new NotFoundException("Room not found with id " + roomId + " in cinema with id " + cinemaId);
        }
        existingRoom.setName(rooms.getName());
        existingRoom.setSeats(rooms.getSeats());
        Rooms updatedRoom = roomsService.updateRoom(roomId, existingRoom);
        return ResponseEntity.ok().body(updatedRoom);
    }

    @DeleteMapping("/{cinemaId}/rooms/{roomId}")
    public ResponseEntity<Void> deleteRoom(@PathVariable int cinemaId, @PathVariable int roomId) {
        Cinemas cinemas = cinemasService.getCinema(cinemaId);
        Rooms existingRoom = roomsService.getRoom(roomId);
        if (existingRoom.getCinema().getId() != cinemas.getId()) {
            throw new NotFoundException("Room not found with id " + roomId + " in cinema with id " + cinemaId);
        }
        roomsService.deleteRoom(roomId);
        return ResponseEntity.noContent().build();
    }

    // API to add seatlist
    @PostMapping("/seatlist")
    public ResponseEntity<SeatList> addSeatList( @RequestBody SeatList seatList) {
        SeatList savedSeatList = seatlistService.createSeatlist(seatList);
        return new ResponseEntity<>(savedSeatList, HttpStatus.CREATED);
    }

    // API to update seatlist
    @PutMapping("/seatlist/{seatListId}")
    public ResponseEntity<SeatList> updateSeatList(@PathVariable int seatListId,@RequestBody SeatList seatList) {
        SeatList updatedSeatList = seatlistService.updateSeatlist(seatListId, seatList);
        return new ResponseEntity<>(updatedSeatList, HttpStatus.OK);
    }

    // API to delete seatlist
    @DeleteMapping("/seatlist/{seatListId}")
    public ResponseEntity<Void> deleteSeatList(@PathVariable int seatListId) {
        seatlistService.deleteSeatlist(seatListId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // API to get seatlist by id
    @GetMapping("/seatlist/{seatListId}")
    public ResponseEntity<SeatList> getSeatList( @PathVariable int seatListId) {
        try {
            SeatList seatList = seatlistService.getSeatlist(seatListId);
            return new ResponseEntity<>(seatList, HttpStatus.OK);
        }catch (NotFoundException notFoundException){
            throw new NotFoundException("Không có dãy ghế với ID:"+seatListId);}
    }

    // API to get all seatlists by cinemaId and roomId
    @GetMapping("/seatlist")
    public ResponseEntity<List<SeatList>> getAllSeatLists() {
        List<SeatList> seatLists = seatlistService.getAllSeatlist();
        if (seatLists.isEmpty()) {
            throw new NotFoundException("Không có danh sách ghế nào.");
        }
        return new ResponseEntity<>(seatLists, HttpStatus.OK);
    }



    // API to get available seat numbers by seat list
    @GetMapping("/rooms/{roomId}/seatlist/{seatListId}/available-seatnumbers")
    public ResponseEntity<List<SeatNumber>> getAvailableSeatNumbersBySeatListId(  @PathVariable int seatListId) {
        List<SeatNumber> availableSeatNumbers = seatNumberService.getAvailableSeatNumbersBySeatList(seatListId);
        return new ResponseEntity<>(availableSeatNumbers, HttpStatus.OK);
    }

    // API to add seat number
    @PostMapping("/rooms/{roomId}/seatlist/{seatListId}/seatnumbers")
    public ResponseEntity<SeatNumber> addSeatNumber( @PathVariable int seatListId, @RequestBody SeatNumber seatNumber) {
        SeatList seatList = seatlistService.getSeatlist(seatListId);
        seatNumber.setSeatList(seatList);
        SeatNumber newSeatNumber = seatNumberService.createSeatNumber(seatNumber);
        return new ResponseEntity<>(newSeatNumber, HttpStatus.CREATED);
    }

    // API to update seat number
    @PutMapping("/rooms/{roomId}/seatlist/{seatListId}/seatnumbers/{seatNumberId}")
    public ResponseEntity<SeatNumber> updateSeatNumber( @PathVariable int roomId, @PathVariable int seatListId, @PathVariable int seatNumberId, @RequestBody SeatNumber seatNumber) {
       try{ SeatNumber existingSeatNumber = seatNumberService.getSeatNumber(seatNumberId);
        SeatList seatList = seatlistService.getSeatlist(seatListId);
        existingSeatNumber.setSeatList(seatList);
        existingSeatNumber.setNumber(seatNumber.getNumber());
        existingSeatNumber.setStatus(seatNumber.getStatus());
        existingSeatNumber.setRooms(seatNumber.getRooms());
        SeatNumber updatedSeatNumber = seatNumberService.updateSeatNumber(seatNumberId, existingSeatNumber);
        return new ResponseEntity<>(updatedSeatNumber, HttpStatus.OK);}
       catch (NotFoundException notFoundException){
           throw new NotFoundException("Không có ghê với id :"+seatNumberId);
       }
    }

    // API to delete seat number
    @DeleteMapping("/rooms/{roomId}/seatlist/{seatListId}/seatnumbers/{seatNumberId}")
    public ResponseEntity<?> deleteSeatNumber( @PathVariable int roomId, @PathVariable int seatListId, @PathVariable int seatNumberId) {
        seatNumberService.deleteSeatNumber(seatNumberId);
        return ResponseEntity.ok().build();
    }

}
