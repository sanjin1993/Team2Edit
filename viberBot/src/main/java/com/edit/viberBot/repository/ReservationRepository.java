package com.edit.viberBot.repository;

import com.edit.viberBot.model.Reservation;
import com.edit.viberBot.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {


    public Iterable<Reservation> getByUser(@Param("viberId") String viberId);
    public Reservation findByRoute(Route route);
    public Reservation findById(int id);
}
