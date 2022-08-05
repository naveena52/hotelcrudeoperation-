package com.example.hotel.management.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="hotel details")
public class hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String hotelname;

    public String gethotelname() {
        return hotelname;
    }

    public void sethotelname(String hotelname) {
        hotelname = hotelname;
    }

    @Column
    private String hotelstate;

    @Column
    private int hotelrank;

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int gethotelrank() {
        return hotelrank;
    }

    public void sethotelrank(int hotelrank) {
        this.hotelrank = hotelrank;
    }
}




