package com.example.hotel.management.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class role {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
}
