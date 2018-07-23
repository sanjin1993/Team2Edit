package com.edit.viberBot.service;

import com.edit.viberBot.model.Route;
import com.edit.viberBot.repository.RouteRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    @Autowired
    RouteRep routeRep;

    public void save(Route route) {
        routeRep.save(route);
    }
}
