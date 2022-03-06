package com.model;

import javax.persistence.*;

@Entity
@Table(name="order")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name ="oid")
    private int oid;

    @Column(name="total_amount")
    private double totalAmount;

    @Column(name="total_seats")
    private int totalSeats;

    @ManyToOne
    @JoinColumn(name="flight_id", nullable = false)
    private Flight fid;

    @ManyToOne
    @JoinColumn(name="payment_id", nullable = false)
    private Payment pid;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable = false)
    private Customer cid;


    public Order(){

    }

    public Order(int oid, Flight fid, double totalAmount, int totalSeats, Payment pid, Customer cid) {
        this.oid = oid;
        this.fid = fid;
        this.totalAmount = totalAmount;
        this.totalSeats = totalSeats;
        this.pid = pid;
        this.cid = cid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Flight getFid() {
        return fid;
    }

    public void setFid(Flight fid) {
        this.fid = fid;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Payment getPid() {
        return pid;
    }

    public void setPid(Payment pid) {
        this.pid = pid;
    }

    public Customer getCid() {
        return cid;
    }

    public void setCid(Customer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "order{" +
                "oid=" + oid +
                ", fid=" + fid +
                ", totalAmount=" + totalAmount +
                ", totalSeats=" + totalSeats +
                ", pid=" + pid +
                ", cid=" + cid +
                '}';
    }
}
