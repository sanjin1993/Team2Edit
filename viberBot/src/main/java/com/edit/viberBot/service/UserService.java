package com.edit.viberBot.service;

import com.edit.viberBot.model.Route;
import com.edit.viberBot.model.User;
import com.edit.viberBot.repository.RouteRep;
import com.edit.viberBot.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRep userRep;


    public void save(User user) {
        userRep.save(user);
    }

    public User find(String viberId)
    {
        return userRep.findByViberId(viberId);
    }


}