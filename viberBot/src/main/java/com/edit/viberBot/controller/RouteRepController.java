package com.edit.viberBot.controller;

import com.edit.viberBot.model.Route;
import com.edit.viberBot.model.User;
import com.edit.viberBot.repository.RouteRep;
import com.edit.viberBot.repository.UserRep;
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
public class RouteRepController {

    @Autowired
    RouteRep repository;

<<<<<<< HEAD


    @RequestMapping(value = "/home", method = RequestMethod.GET)
=======
    @RequestMapping(value = "/home", method = RequestMethod.GET)

>>>>>>> e1715571d9d0df6d0dfaafc218249bdf0f3db28e
    public String Home()
    {
        return "Home";
    }


    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public RedirectView SaveRoutes() {
        LocalDate d =  LocalDate.now();
        LocalTime t = LocalTime.now();
        Date date = Date.from(d.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Time time = new Time(t.getHour(), t.getMinute(), t.getSecond());

        repository.save(new Route("pozicija5","pozicija61",date,time,12));
        repository.save(new Route("pozicija51","pozicija26",date,time,12));
        repository.save(new Route("pozicija15","pozicija36",date,time,12));
        repository.save(new Route("pozicija25","pozicija46",date,time,12));
        repository.save(new Route("pozicija35","pozicija116",date,time,12));

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8090/findAll");
        return redirectView;
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("routes", repository.findAll());
        return "Routes";
    }

    @RequestMapping(value="/findRouteById/{id}" , method = RequestMethod.GET)
    public String findRouteById(@PathVariable("id") int Id, Model model) {
        model.addAttribute("model", repository.findById(Id));
        return "Route";
    }

    @RequestMapping(value = "/delete/{id}")
    public RedirectView  deleteRoute(@PathVariable("id") int Id) {

        Route r = repository.findById(Id);
        repository.delete(r);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8090/findAll");
        return redirectView;
}

    @RequestMapping(value = "/edit/{id}" , method = RequestMethod.GET)
    public String  editRoute(@PathVariable("id") int Id , Model model) {
        model.addAttribute("model", repository.findById(Id));
        return "Edit";
    }

    @RequestMapping(value = "/dodaj" , method = RequestMethod.GET)
    public String  addRoute() {
        return "Dodaj";
    }

    @RequestMapping(value = "/snimiEdit/{id}" , method = RequestMethod.POST)
    public RedirectView  snimiEdit(@PathVariable("id") int Id ,@RequestParam("start") String start ,@RequestParam("destination") String destination ,@RequestParam("date") String date ,@RequestParam("time") Time time ,@RequestParam("availableSeats") int availableseasts) {

        Route route = repository.findById(Id);
        Date dateToEdit = new Date(date);
        RouteService rs = new RouteService();

        route.setStart(start);
        route.setDestination(destination);
        route.setDate(dateToEdit);
        route.setTime(time);
        route.setAvailableSeats(availableseasts);

        rs.save(route);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8090/findAll");
        return redirectView;
    }

}


