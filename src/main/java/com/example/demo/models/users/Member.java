package com.example.demo.models.users;

import com.example.demo.accounts.Account;

import javax.persistence.*;

/**
 * Created by edwar on 4/27/2018.
 */
@Entity
public class Member {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String firstName;
    private String lastName;
    @OneToOne
    private Account account;
    private String email;
    private long mobileNr;

    public Member() {
    }

    public Member(String firstName, String lastName, Account account, String email, long mobileNr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
}
