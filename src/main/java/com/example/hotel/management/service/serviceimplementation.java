package com.example.hotel.management.service;
import com.example.hotel.management.model.hotel;
import com.example.hotel.management.repository.hotelrepo;
import com.example.hotel.management.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class serviceimplementation implements service
{
    @Autowired
    private hotelrepo hotelRepo;

    public serviceimplementation
            (hotelrepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    @Override
    public hotel savehotel(hotel hotel)
    {
        return hotelRepo.save(hotel);
    }
    @Override
    public List<hotel> getAllhotel()
    {

        return (List<hotel>) hotelRepo.findAll();
    }
    @Override

    public hotel gethotelById(int id)
    {
        return hotelRepo.findById(id).orElseThrow();
    }
    @Override
    public hotel updatehotel(hotel hotel, int id)
    {
        hotel existinghotel=hotelRepo.findById(id).orElseThrow();

        existinghotel.setHotelname(hotel.gethotelname());
        existinghotel.setHotelstate(hotel.getHotelstate());
        existinghotel.sethotelrank(hotel.gethotelrank());
        hotelRepo.save(existinghotel);
        return existinghotel;
    }

    @Override
    public hotel updateBook(hotel hotel, int id) {
        return null;
    }

    @Override
    public void deletehotel(int id) {
        hotelRepo.findById(id).orElseThrow();
        hotelRepo.deleteById(id);
    }

}

