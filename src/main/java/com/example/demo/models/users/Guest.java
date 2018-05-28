package com.example.demo.models.users;

import com.example.demo.accounts.Account;

import javax.persistence.*;

/**
 * Created by edwar on 4/27/2018.
 */
@Entity
public class Guest {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String firstName;
    private String lastName;
    //something for date and time, or maybe just a timestamp when sending the request
    private String email;
    private long mobileNr;
    @OneToOne
    private Account account;

    public Guest() {
    }

    public Guest(String firstName, String lastName, String email, long mobileNr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNr = mobileNr;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobileNr() {
        return mobileNr;
    }

    public void setMobileNr(long mobileNr) {
        this.mobileNr = mobileNr;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
