package com.example.hotel.management.security;

import com.example.hotel.management.repository.hotelrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class hoteldetails implements UserDetailsService {
    @Autowired
    private hotelrepo hotelrepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        return hotelrepo.findByEmail(username).orElseThrow();
    }

}
