package com.edit.viberBot.controller;

import com.edit.viberBot.model.Route;
import com.edit.viberBot.model.User;
import com.edit.viberBot.repository.RouteRepository;
import com.edit.viberBot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class UserController {
    @Autowired
    UserRepository repository;
    @RequestMapping(value = "/saveUser", method = RequestMethod.GET)
    public String SaveUsers() {

        repository.save(new User("1","User1",true));
        repository.save(new User("2","User2",false));
        repository.save(new User("3","User3",true));
        repository.save(new User("4","User4",false));
        repository.save(new User("5","User5",true));
        return "Ok";
    }
}


