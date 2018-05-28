package com.example.demo.repos;

import com.example.demo.models.Tour;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by edwar on 2/10/2018.
 */
public interface TourRepository extends CrudRepository<Tour, Long> {
    //Iterable<Tour> findAllByCountry_CountryName(String country);
    Tour getTourById(Long id);
}
