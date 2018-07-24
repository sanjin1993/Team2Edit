package com.edit.viberBot.service;

import com.edit.viberBot.repository.ReservationRepository;
import com.edit.viberBot.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository routeRep;
}
