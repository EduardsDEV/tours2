package com.example.demo.controllers;

import com.example.demo.models.City;
import com.example.demo.models.Country;
import com.example.demo.models.Tour;
import com.example.demo.repos.CityRepository;
import com.example.demo.repos.TourRepository;
import com.example.demo.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by edwar on 2/10/2018.
 */
@RestController
public class TourController {

    private final TourService tourService;

    @Autowired
    private TourRepository tourRepository;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }


    @GetMapping("/tour/tourInfo")
    public ModelAndView viewTourInfo(
            @RequestParam(name = "id", defaultValue = "0")
                    long id) {
        ModelAndView mv = new ModelAndView("admin/tour");
        mv.getModel().put("tour", tourRepository.findOne(id));
        return mv;
    }

    @GetMapping("/tours/shownew")
    public ModelAndView showTournew() {
        ModelAndView mv = new ModelAndView("user/allToursNew");
        mv.getModel().put("toursList", tourService.findAllTours());
        return mv;
    }

    @GetMapping("/tours/byCountry")
    public ModelAndView showByCountry(
            @RequestParam(name = "country", defaultValue = "")
                    String country) {
        ModelAndView mv = new ModelAndView("user/ToursByCountry");
        mv.getModel().put("tourByCountryList", tourService.findByCountryName(country));
        return mv;
    }

    @GetMapping("/tours/byCity")
    public ModelAndView showByCity(
            @RequestParam(name = "city", defaultValue = "")
                    String city) {
        ModelAndView mv = new ModelAndView("user/ToursByCity");
        mv.getModel().put("toursByCityList", tourService.findByCityName(city));
        return mv;
    }
}
