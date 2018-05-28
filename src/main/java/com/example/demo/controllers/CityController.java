package com.example.demo.controllers;

import com.example.demo.repos.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by edwar on 3/19/2018.
 */
@Controller
public class CityController {
    @Autowired
    CityRepository cityRepository;

    @GetMapping("/cities")
    public ModelAndView showCities(){
        ModelAndView mv = new ModelAndView("user/cities");
        mv.getModel().put("cityList", cityRepository.findAll());
        return mv;
    }


}
