package com.example.demo.repos;

import com.example.demo.models.TourRequest;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by edwar on 11/30/2017.
 */
public interface TourRequestRepository extends CrudRepository<TourRequest, Long> {
}
