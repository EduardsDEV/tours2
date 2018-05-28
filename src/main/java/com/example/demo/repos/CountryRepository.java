package com.example.demo.repos;

import com.example.demo.models.Country;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by edwar on 3/19/2018.
 */
public interface CountryRepository extends CrudRepository<Country, Integer> {

}
