package com.edit.viberBot.repository;

import com.edit.viberBot.model.Reservation;
import com.edit.viberBot.model.Route;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation,Long> {

}
