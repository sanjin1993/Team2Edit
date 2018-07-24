package com.edit.viberBot.repository;

import com.edit.viberBot.model.Route;
import com.edit.viberBot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Stream;

public interface RouteRepository extends JpaRepository<Route,Integer>{
    public Route findById(int id);
    public List<Route> findAllByViberId(String viberId);
}