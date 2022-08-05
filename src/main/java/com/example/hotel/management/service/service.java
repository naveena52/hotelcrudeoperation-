package com.example.hotel.management.service;



import com.example.hotel.management.model.hotel;

import java.util.List;

public interface service {


    hotel savehotel(hotel hotel);

    List<hotel> getAllhotel();
    hotel gethotelById(int id);
    hotel updatehotel(hotel hotel,int id);

    hotel updateBook(hotel hotel, int id);

    void deletehotel(int id);
}




