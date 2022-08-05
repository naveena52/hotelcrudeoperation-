package com.example.hotel.management.controller;
import com.example.hotel.management.model.hotel;
import com.example.hotel.management.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class hotelControllers {
    @Autowired
    private service hotelService;

    public hotelControllers(service hotelService) {
        this.hotelService = hotelService;
    }
    @PostMapping
    public ResponseEntity<hotel> saveBook(@RequestBody hotel hotel)
    {
        return new ResponseEntity<hotel>(hotelService.savehotel(hotel), HttpStatus.CREATED);
    }
    @GetMapping
    public List<hotel> getAllBooks()
    {
        return hotelService.getAllhotel();
    }
    @GetMapping("{id}")
    public ResponseEntity<hotel> getBookById(@PathVariable("id")int id)
    {
        return new ResponseEntity<hotel>(hotelService.gethotelById(id), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<hotel> updateBook(@PathVariable("id")int id,@RequestBody hotel hotel)
    {
        return new ResponseEntity<hotel>(hotelService.updatehotel(hotel,id), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletehotel(@PathVariable("id")int id)
    {
        hotelService.deletehotel(id);
        return new ResponseEntity<String>("hotel data deleted successfully",HttpStatus.OK);
    }
}

