package com.example.hotel.management.repository;


import com.example.hotel.management.model.hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface hotelrepo extends JpaRepository<hotel,Integer>
{
    Optional<hotel> findByEmail(String email);
}
