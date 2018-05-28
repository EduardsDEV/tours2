package com.example.demo.controllers;

import com.example.demo.services.TourService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by edwar on 2/10/2018.
 */
@Controller
public class HomepageController {

    private final TourService tourService;

    public HomepageController(TourService tourService) {
        this.tourService = tourService;
    }


    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("homepage");
        mv.getModel().put("toursList", tourService.findAllTours());
        return mv;
    }
}
