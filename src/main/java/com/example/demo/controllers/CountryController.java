package com.example.demo.controllers;

import com.example.demo.repos.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by edwar on 3/19/2018.
 */
@Controller
public class CountryController {
    @Autowired
    CountryRepository countryRepository;

    @GetMapping("/countries")
    public ModelAndView showCountries(){
        ModelAndView mv = new ModelAndView("user/countries");
        mv.getModel().put("countryList", countryRepository.findAll());
        return mv;
    }
}
