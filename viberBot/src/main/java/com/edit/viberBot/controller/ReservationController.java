package com.edit.viberBot.controller;


import com.edit.viberBot.model.Reservation;
import com.edit.viberBot.model.Route;
import com.edit.viberBot.model.User;
import com.edit.viberBot.repository.ReservationRepository;
import com.edit.viberBot.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class ReservationController {


    @Autowired
    ReservationRepository repository;


    @RequestMapping(value = "/saveReservation", method = RequestMethod.GET)
    public String SaveRoutes() {
        LocalDate d =  LocalDate.now();
        LocalTime t = LocalTime.now();

        repository.save(new Reservation(new User("123", "User1", false), new Route("Mostar", "Sarajevo", d, t, 12), 11));
        repository.save(new Reservation(new User("1234","User12",false),new Route("Mostar","Zenica",d,t,12),11));
        repository.save(new Reservation(new User("1235","User13",false),new Route("Jablanica","Konjic",d,t,12),11));
        repository.save(new Reservation(new User("12356","User14",false),new Route("Brcko","Banjaluka",d,t,12),11));

        return "redirect:/" +"findAllReservation";
    }

    @RequestMapping(value = "/findAllReservation", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("reservations", repository.findAll());
        return "ReservationViews/Index";
    }

    @RequestMapping(value="/findRezervatonById/{id}" , method = RequestMethod.GET)
    public String findRouteById(@PathVariable("id") Long Id, Model model) {
        model.addAttribute("reservation", repository.findById(Id).get());
        return "ReservationViews/Rezervation";
    }

    @RequestMapping(value = "/deleteReservation/{id}")
    public String  deleteRoute(@PathVariable("id") Long Id) {

        Reservation r = repository.findById(Id).get();
        repository.delete(r);
        return "redirect:/" +"findAllReservation";
    }
}
