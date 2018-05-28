package com.example.demo.controllers;

import com.example.demo.accounts.Account;
import com.example.demo.models.Tour;
import com.example.demo.models.TourRequest;
import com.example.demo.models.users.Guest;
import com.example.demo.repos.AccountRepository;
import com.example.demo.repos.GuestRepository;
import com.example.demo.repos.TourRepository;
import com.example.demo.repos.TourRequestRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;

/**
 * Created by edwar on 5/8/2018.
 */
@Controller
public class GuestController {
    private final AccountRepository accountRepository;
    private final TourRepository tourRepository;
    private final GuestRepository guestRepository;
    private final TourRequestRepository tourRequestRepository;

    public GuestController(AccountRepository accountRepository, TourRepository tourRepository, GuestRepository guestRepository, TourRequestRepository tourRequestRepository){
        this.accountRepository = accountRepository;
        this.tourRepository = tourRepository;
        this.guestRepository = guestRepository;
        this.tourRequestRepository = tourRequestRepository;
    }

    @GetMapping("/guest/apply")
    public ModelAndView applyForTour(
            @RequestParam(name = "id", defaultValue = "0")
                    long tourId,
            Authentication authentication) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        Account ac = accountRepository.findByUsername(username);


        Tour t = tourRepository.getTourById(tourId);
        Guest g = guestRepository.getGuestByAccount(ac);

        TourRequest tr = new TourRequest();

        tr.setGuest(g);
        System.out.println(g.getFirstName());
        tr.setTour(t);
        tr.setTimestamp(LocalDateTime.now());
        tr.setMobileNr(g.getMobileNr());
        tr.setCustomerName(g.getFirstName()+ " " + g.getLastName());
        tr.setCustomerEmail(g.getEmail());
        tr.setTourName(t.getName());

        t.getTourRequests().add(tr);
        tourRequestRepository.save(tr);

        tourRepository.save(t);


        return new ModelAndView(new RedirectView("/tours/shownew", true));
    }


}
