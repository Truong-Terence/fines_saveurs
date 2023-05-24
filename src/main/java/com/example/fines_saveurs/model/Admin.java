package com.example.fines_saveurs.model;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;

public class Admin {
    private Long id;

    private String email;

    private String password;
    private String firstname;
    private String lastname;
    private Boolean status = false;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Admin(Long id, String email, String password, String firstname, String lastname) {
        this.id = id;
        this.email = email ;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;

    }
    public Admin(String email, String password, String firstname, String lastname) {
        this.email = email ;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Admin(Long id, String email, String password) {
        this.id = id;
        this.email = email ;
        this.password = password;
    }

    public Admin(String email, String password) {
        this.email = email ;
        this.password = password;
    }

    public Admin(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
