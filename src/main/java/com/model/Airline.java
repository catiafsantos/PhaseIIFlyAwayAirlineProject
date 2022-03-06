package com.model;

import javax.persistence.*;

@Entity
@Table(name="airline")
public class Airline {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name ="aid")
    private int aid;

    @Column(name="airline_name")
    private String airline;

	public Airline() {
        }

    public Airline(int aid, String airline) {
        this.aid = aid;
        this.airline = airline;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "aid=" + aid +
                ", airline='" + airline + '\'' +
                '}';
    }
}
