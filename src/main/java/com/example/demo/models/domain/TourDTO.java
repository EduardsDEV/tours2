package com.example.demo.models.domain;

/**
 * Created by edwar on 2/27/2018.
 */
public class TourDTO {
    private long id;
    private String name;
    private String description;
    private Integer price;
    private String city;
    private String country;
    private String duration;
    private String qtyPeople;

    public TourDTO(long id, String name, String description, Integer price, String city, String country, String duration, String qtyPeople) {
        this.id= id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.city = city;
        this.country = country;
        this.duration = duration;
        this.qtyPeople = qtyPeople;
    }

    public long getId() {
        return id;
    }

    public String getQtyPeople() {
        return qtyPeople;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getDuration() {
        return duration;
    }
}
