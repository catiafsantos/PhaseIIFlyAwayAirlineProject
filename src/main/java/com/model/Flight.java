package com.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="fid")
    private int fid;

    @ManyToOne
    @JoinColumn(name="source", nullable = false)
    private Place source;

    @ManyToOne
    @JoinColumn(name="destination", nullable = false)
    private Place destination;

    @Column(name="date")
    private Date date;

    @Column(name="price")
    private double price;

    @ManyToOne
    @JoinColumn(name="airline", nullable = false)
    private Airline aid;

    @Column(name="seats")
    private int seats;

    public Flight(){}

    public Flight(int fid, Place source, Place destination, Date date, double price, Airline aid, int seats) {
        this.fid = fid;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.price = price;
        this.aid = aid;
        this.seats = seats;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public Place getSource() {
        return source;
    }

    public void setSource(Place source) {
        this.source = source;
    }

    public Place getDestination() {
        return destination;
    }

    public void setDestination(Place destination) {
        this.destination = destination;
    }

    public java.sql.Date getDate() {
        return (java.sql.Date) date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Airline getAid() {
        return aid;
    }

    public void setAid(Airline aid) {
        this.aid = aid;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "fid=" + fid +
                ", source=" + source +
                ", destination=" + destination +
                ", date=" + date +
                ", price=" + price +
                ", aid=" + aid +
                ", seats=" + seats +
                '}';
    }
}