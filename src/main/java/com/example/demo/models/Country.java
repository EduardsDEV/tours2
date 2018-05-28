package com.example.demo.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by edwar on 2/10/2018.
 */
@Entity
public class Country {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String countryName;
    @OneToMany(mappedBy = "country")
    private List<City> cities;

    public String getCountryName() {
        return countryName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
