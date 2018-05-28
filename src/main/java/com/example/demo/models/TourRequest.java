package com.example.demo.models;

import com.example.demo.LocalDateTimeAttributeConverter;
import com.example.demo.models.users.Guest;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by edwar on 11/29/2017.
 */
@Entity
public class TourRequest {
    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    @NotNull
    private Tour tour;
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime timestamp;
    private long mobileNr;
    private String customerName;
    private String customerEmail;
    private String tourName;
    @ManyToOne
    private Guest guest;

    public TourRequest() {

    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getMobileNr() {
        return mobileNr;
    }

    public void setMobileNr(long mobileNr) {
        this.mobileNr = mobileNr;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
