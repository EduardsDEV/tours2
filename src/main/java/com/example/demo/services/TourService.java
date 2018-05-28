package com.example.demo.services;

import com.example.demo.models.Tour;
import com.example.demo.models.domain.TourDTO;
import com.example.demo.repos.TourRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by edwar on 2/27/2018.
 */
@Service
public class TourService {

    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public List<TourDTO> findAllTours() {
        Iterable<Tour> tours = tourRepository.findAll();
        List<TourDTO> tourDTOS = new LinkedList<>();
        for (Tour tour : tours) {
            tourDTOS.add(convertTour(tour));
        }

        return tourDTOS;
    }


    public List<TourDTO> findByCountryName(String countryName) {

        Iterable<Tour> tours = tourRepository.findAll();
        List<TourDTO> tourDTOSByCountry = new LinkedList<>();

        for (Tour tour : tours) {
            if (tour.getCity().getCountry().getCountryName().equals(countryName)) {
                tourDTOSByCountry.add(convertTour(tour));
            }
        }

        return tourDTOSByCountry;
    }


    public List<TourDTO> findByCityName(String cityName) {

        Iterable<Tour> tours = tourRepository.findAll();
        List<TourDTO> tourDTOSByCountry = new LinkedList<>();

        for (Tour tour : tours) {
            if (tour.getCity().getCityName().equals(cityName)) {
                tourDTOSByCountry.add(convertTour(tour));
            }
        }

        return tourDTOSByCountry;
    }

    private TourDTO convertTour(Tour tour) {
        long id = tour.getId();
        String description = tour.getDescription();
        String name = tour.getName();
        Integer price = tour.getPrice();
        String cityName = tour.getCity().getCityName();
        String countryName = tour.getCity().getCountry().getCountryName();
        String duration = tour.getDuration();
        String qtyPqople = tour.getQtyPeople();

        return new TourDTO(id, name, description, price, cityName, countryName,duration, qtyPqople);
    }
}
