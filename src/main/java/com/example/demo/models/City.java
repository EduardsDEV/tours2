package com.example.demo.models;

import javax.persistence.*;

/**
 * Created by edwar on 2/10/2018.
 */
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String cityName;
    @ManyToOne
    private Country country;
//    @OrderColumn
//    @ElementCollection(targetClass=Tour.class)
//    private Tour[] tours;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    //    public Tour[] getTours() {
//        return tours;
//    }
//
//    public void setTours(Tour[] tours) {
//        this.tours = tours;
//    }


    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                '}';
    }
}
