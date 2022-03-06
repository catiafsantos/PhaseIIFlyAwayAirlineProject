package com.model;

import javax.persistence.*;

@Entity
@Table(name="payment")
public class Payment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name ="pid")
    private int pid;

    @Column(name="method")
    private String method;

    @Column(name="payment_details")
    private String paymentDetails;

    public Payment(){

    }

    public Payment(int pid, String method, String paymentDetails) {
        this.pid = pid;
        this.method = method;
        this.paymentDetails = paymentDetails;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "pid=" + pid +
                ", method='" + method + '\'' +
                ", paymentDetails='" + paymentDetails + '\'' +
                '}';
    }
}
