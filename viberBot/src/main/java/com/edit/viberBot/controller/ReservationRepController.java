package com.edit.viberBot.controller;


import com.edit.viberBot.model.Reservation;
import com.edit.viberBot.model.Route;
import com.edit.viberBot.model.User;
import com.edit.viberBot.repository.ReservationRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.transaction.Transactional;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

@Controller
public class ReservationRepController {


    @Autowired
    ReservationRep repozitorij;


   @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Home()
    {
        return "Home";
    }


    @RequestMapping(value = "/findAllReservation", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("reservations", repozitorij.findAll());
        return "Reservation";
    }

    @Transactional
    @RequestMapping(value="/saveReservation",method = RequestMethod.GET)
    public RedirectView saveReservations(Model model)
    {

        repozitorij.save(new Reservation(new Route(),1, new User()));


        model.addAttribute("reservations", repozitorij.findAll());

        RedirectView rv=new RedirectView();
        rv.setUrl("http://localhost:8090/findAllReservation");
        return rv;


    }


}
