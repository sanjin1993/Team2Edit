package com.edit.viberBot.service;

import com.edit.viberBot.model.Route;
import com.edit.viberBot.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Convert;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class RouteService {

    @Autowired
    RouteRepository routeRepository;

    public List<Route> findAll() {

        List<Route> routes = routeRepository.findAll();
        for(int i = 0; i < routes.size(); i++) {
            if(routes.get(i).getDate().compareTo(LocalDate.now()) < 0) {
                routes.remove(i);
                i--;
            }
        }
        return routes;

    }
    @Transactional
    public void save(Route route) {
        routeRepository.save(route);
    }

    @Transactional
    public Route saveRoute (Route route) {
        return routeRepository.save(route);
    }

    @Transactional
    public void delete(int id) {
        routeRepository.deleteById(id);
    }

    public Route findById(int id) {
        return routeRepository.findById(id);
    }

    @Transactional
    public Route edit(int id, Route route) {
        Route routeToEdit = routeRepository.findById(id);

        routeToEdit.setStart(route.getStart());
        routeToEdit.setDestination(route.getDestination());
        routeToEdit.setDate(route.getDate());
        routeToEdit.setTime(route.getTime());
        routeToEdit.setAvailableSeats(route.getAvailableSeats());

        return routeToEdit;
    }

    public List<Route> findAllByViberId(String viberId)
    {
        List<Route> routes = routeRepository.findAllByViberId(viberId);
        for (int i=0; i<routes.size();i++)
        {
            if (routes.get(i).getDate().compareTo(LocalDate.now())<0)
            {
                routes.remove(i);
                i--;
            }
        }
        return routes;
    }

}
