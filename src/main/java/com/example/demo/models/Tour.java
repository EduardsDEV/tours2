package com.example.demo.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by edwar on 2/10/2018.
 */
@Entity
public class Tour {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String name;
    private String description;
    private Integer price;
    private String duration;
    private String qtyPeople;
    private String longDescription;
    private String color;
    @ManyToOne
    private City city;
    @ManyToOne
    private Country country;

    @ManyToMany
    private List<TourRequest> tourRequests;

    public Tour() {
    }

    public Tour(String name, String description, Integer price, City city, Country country, String duration, String qtyPeople, String longDescription) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.city = city;
        this.country = country;
        this.duration = duration;
        this.qtyPeople = qtyPeople;
        this.longDescription = longDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getQtyPeople() {
        return qtyPeople;
    }

    public void setQtyPeople(String qtyPeople) {
        this.qtyPeople = qtyPeople;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<TourRequest> getTourRequests() {
        return tourRequests;
    }
}
