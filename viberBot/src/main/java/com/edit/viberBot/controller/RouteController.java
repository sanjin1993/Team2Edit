package com.edit.viberBot.controller;

import com.edit.viberBot.model.Route;
import com.edit.viberBot.repository.RouteRepository;
import com.edit.viberBot.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;


@Controller
public class RouteController {

    @Autowired
    RouteRepository repository;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String SaveRoutes() {
        LocalDate d =  LocalDate.now();
        LocalTime t = LocalTime.now();

        repository.save(new Route("pozicija5","pozicija61",d,t,12));
        repository.save(new Route("pozicija51","pozicija26",d,t,123));
        repository.save(new Route("pozicija15","pozicija36",d,t,124));
        repository.save(new Route("pozicija25","pozicija46",d,t,1245));
        repository.save(new Route("pozicija35","pozicija116",d,t,12431));

        return "redirect:/" +"findAll";
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("routes", repository.findAll());
        return "RouteViews/Index";
    }

    @RequestMapping(value="/findRouteById/{id}" , method = RequestMethod.GET)
    public String findRouteById(@PathVariable("id") Long Id, Model model) {
        model.addAttribute("route", repository.findById(Id).get());
        return "RouteViews/Route";
    }

    @RequestMapping(value = "/delete/{id}")
    public String  deleteRoute(@PathVariable("id") Long Id) {

        Route r = repository.findById(Id).get();
        repository.delete(r);
        return "redirect:/" +"findAll";
}

    @RequestMapping(value = "/edit/{id}" , method = RequestMethod.GET)
    public String  editRoute(@PathVariable("id") Long Id , Model model) {
        model.addAttribute("model", repository.findById(Id).get());
        return "RouteViews/Edit";
    }

    @RequestMapping(value = "/Dodaj" , method = RequestMethod.GET)
    public String  addRoute(Model model) {
        model.addAttribute("model", new Route());
        return "RouteViews/Add";
    }
    @RequestMapping(value = "/snimiEdit/{id}" , method = RequestMethod.POST)
    public String  snimiEdituj(@PathVariable("id") Long Id ,@RequestParam("start") String start ,@RequestParam("destination") String destination ,@RequestParam("date") String date ,@RequestParam("time") String time ,@RequestParam("availableSeats") int availableseasts) {

        Route route = repository.findById(Id).get();
        //RouteService rs = new RouteService();
        route.setStart(start);
        route.setDestination(destination);
        route.setDate(LocalDate.parse(date));
        route.setTime(LocalTime.parse(time));
        route.setAvailableSeats(availableseasts);
        repository.save(route);
        return "redirect:/" +"findAll";
    }

    @RequestMapping(value = "/snimiAdd" , method = RequestMethod.POST)
    public String  snimiDodaj(@RequestParam("start") String start ,@RequestParam("destination") String destination ,@RequestParam("date") String date ,@RequestParam("time") String time ,@RequestParam("availableSeats") int availableseasts) {
        Route route = new Route();
        route.setStart(start);
        route.setDestination(destination);
        route.setDate(LocalDate.parse(date));
        route.setTime(LocalTime.parse(time));
        route.setAvailableSeats(availableseasts);
        repository.save(route);
        return "redirect:/" +"findAll";
    }
}


