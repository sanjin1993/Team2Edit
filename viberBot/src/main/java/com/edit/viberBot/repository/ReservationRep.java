package com.edit.viberBot.repository;

import com.edit.viberBot.model.Reservation;
import com.edit.viberBot.model.Route;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRep extends CrudRepository<Reservation,Long> {

    /*
    * Service has 5 functions:
-findAll()
-findById(int id)
-save(Reservation reservation)
-delete(int id)
-findReservationByRoute(Route route)
    *
    * */
    List<Reservation> findAll();
    Reservation findById(int id);
    //void save(Reservation reservation);
   // Reservation delete(int id);
    Route findReservationByRoute(Route route);

}
