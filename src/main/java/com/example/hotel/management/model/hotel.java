package com.example.hotel.management.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name="hotel details")
public class hotel implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String hotelname;

    public String gethotelname()
    {
        return hotelname;
    }

    public void sethotelname(String hotelname)
    {
        hotelname = hotelname;
    }

    @Column
    private String hotelstate;

    @Column
    private int hotelrank;
    private  String email;
    private  String password;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="user_role", joinColumns = @JoinColumn(name="books", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="role",referencedColumnName = "id"))
    private Set<role> roles=new HashSet<>();


    public String getHotelname()
    {
        return hotelname;
    }

    public void setHotelname(String hotelname)
    {
        this.hotelname = hotelname;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int gethotelrank()
    {
        return hotelrank;
    }

    public void sethotelrank(int hotelrank)
    {
        this.hotelrank = hotelrank;
    }

    public String getHotelstate() {
        return hotelstate;
    }

    public void setHotelstate(String hotelstate) {
        this.hotelstate = hotelstate;
    }

    public int getHotelrank() {
        return hotelrank;
    }

    public void setHotelrank(int hotelrank) {
        this.hotelrank = hotelrank;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        List<GrantedAuthority> authorities=this.roles.stream().map((role)-> {return new SimpleGrantedAuthority(role.getName());}).collect(Collectors.toList());
        return  authorities;

    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}




