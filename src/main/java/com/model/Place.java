package com.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="plid")
    private int plid;

    @Column(name="country")
    private String country;

    @Column(name="city")
    private String city;

    @Column(name="airport_name")
    private String airportName;

    public Place() {
    }

    public Place(int plid, String country, String city, String airportName) {
        this.plid = plid;
        this.country = country;
        this.city = city;
        this.airportName = airportName;
    }

    public int getPlid() {
        return plid;
    }

    public void setPlid(int plid) {
        this.plid = plid;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    @Override
    public String toString() {
        return "Place{" +
                "plid=" + plid +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", airportName='" + airportName + '\'' +
                '}';
    }
}
