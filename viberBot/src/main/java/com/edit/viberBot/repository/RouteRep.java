package com.edit.viberBot.repository;

import com.edit.viberBot.model.Route;
import com.edit.viberBot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Stream;

public interface RouteRep extends CrudRepository<Route,Long> {
     List<Route> findAll();
     Route findById(int Id);
    //Route delete(int Id);
//     Route Edit(int Id , Route route);
}