package com.model;

import javax.persistence.*;

@Entity
@Table(name="login")
public class Login {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name ="uid")
    private int uid;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="role")
    private String role;

    public Login(){

    }

    public Login(int uid, String email, String password, String role) {
        this.uid = uid;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Login(String email, String password, String role) {
        super();
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Login{" +
                "uid=" + uid +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
