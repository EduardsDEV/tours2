package com.example.demo.controllers;

import com.example.demo.models.City;
import com.example.demo.models.Tour;
import com.example.demo.repos.CityRepository;
import com.example.demo.repos.GuestRepository;
import com.example.demo.repos.TourRepository;
import com.example.demo.repos.TourRequestRepository;
import com.example.demo.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by edwar on 4/8/2018.
 */

@Controller
public class AdminController {


    private final TourService tourService;

    @Autowired
    TourRepository tourRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    TourRequestRepository tourRequestRepository;
    @Autowired
    GuestRepository guestRepository;

    public AdminController(TourService tourService) {
        this.tourService = tourService;
    }


    @PostMapping("/tour/add")
    public ModelAndView saveAndShow(
            @RequestParam(name = "id", defaultValue = "-1")
                    Long id,
            @RequestParam(name = "name", defaultValue = "NO_NAME")
                    String name,
            @RequestParam(name = "description", defaultValue = "NO_DESCRIPTION")
                    String description,
            @RequestParam(name = "city", defaultValue = "NO_CITY")
                    String city,
            @RequestParam(name = "duration", defaultValue = "NO_DURATION")
                    String duration,
            @RequestParam(name = "price", defaultValue = "NO_PRICE")
                    Integer price,
             @RequestParam(name = "qtyPeople", defaultValue = "NO_PEOPLE")
                    String qtyPeople,
            @RequestParam(name = "longDescription", defaultValue = "NO_LONG_DESC")
                    String longDescription){

        Tour t = tourRepository.getTourById(id);
        City tempCity = cityRepository.findByCityName(city);
        System.out.println(tempCity);
        if(tempCity == null){
            tempCity = new City();
        }
        if (t == null) {
            t = new Tour(name, description, price, tempCity, tempCity.getCountry(), duration, qtyPeople, longDescription);
        } else {

            t.setName(name);
            t.setDescription(description);
            t.setCity(tempCity);
            t.setCountry(tempCity.getCountry());
            t.setPrice(price);
            t.setDuration(duration);
            t.setQtyPeople(qtyPeople);
            t.setLongDescription(longDescription);
        }
        tourRepository.save(t);

        ModelAndView mv = new ModelAndView("admin/allTours");
        mv.getModel().put("toursList", tourRepository.findAll());
        mv.getModel().put("cityList", cityRepository.findAll());

        mv.getModel().put("tour", t);

        return mv;
    }

    @GetMapping("/admin/tour/edit")
    public ModelAndView editTour(
            @RequestParam(name = "id", defaultValue = "0")
                    long id) {
        ModelAndView mv = new ModelAndView("admin/editTour");
        Tour tourById = tourRepository.getTourById(id);
        mv.getModel().put("tour", tourById);
        mv.getModel().put("cityList", cityRepository.findAll());
        return mv;


    }


    @GetMapping("/admin/login")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("admin/adminhome");
        mv.getModel().put("toursList", tourService.findAllTours());
        return mv;
    }

    //for login security part
    @GetMapping("/login")
    public String login() {
        return "login";
    }

//    @GetMapping("/admin/tour/add")
//    public String add() {
//        return "admin/addTour";
//    }

    @GetMapping("/admin/tour/add")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView("admin/addTour");
        mv.getModel().put("cityList", cityRepository.findAll());
        return mv;
    }

    @GetMapping("/admin/tour/delete")
    public ModelAndView deleteTour(
            @RequestParam(name = "id", defaultValue = "0")
                    long id) {
        System.out.println("id = " + id);
        Tour t = tourRepository.getTourById(id);
        tourRepository.delete(t);
        if (t == null){

        }
        ModelAndView mv = new ModelAndView("admin/allTours");

        mv.getModel().put("toursList", tourRepository.findAll());

        return mv;


    }

    @GetMapping("/admin/tours/requests")
    public ModelAndView seeTourRequests() {
        ModelAndView mv = new ModelAndView("admin/tourRequests");
        mv.getModel().put("requestsList", tourRequestRepository.findAll());
        mv.getModel().put("guest", guestRepository.findAll());

        return mv;
    }

    @GetMapping("/admin/tours/all")
    public ModelAndView showTours() {
        ModelAndView mv = new ModelAndView("admin/allTours");
        mv.getModel().put("toursList", tourService.findAllTours());
        return mv;
    }
}
