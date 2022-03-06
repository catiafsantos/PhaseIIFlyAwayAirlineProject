package com.model;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name ="cid")
    private int cid;

    @Column(name="customer_name")
    private String cusName;

    public Customer(){

    }

    public Customer(int cid, String cusName) {
        this.cid = cid;
        this.cusName = cusName;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", cusName='" + cusName + '\'' +
                '}';
    }
}

