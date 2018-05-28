package com.example.demo.repos;

import com.example.demo.models.City;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by edwar on 3/19/2018.
 */
public interface CityRepository extends CrudRepository<City, Integer> {
    City findByCityName(String city);

}
