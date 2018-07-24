package com.edit.viberBot.service;

import com.edit.viberBot.model.User;
import com.edit.viberBot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRep;

    @Transactional
    public void add(User user)
    {
        User userExists = userRep.findByViberId(user.getViberId());


        if(userExists == null)
        {
            user.setSubscribed(true);
            userRep.save(user);
        }
        else
        {
            subcribed(user.getViberId());
        }
    }

    @Transactional
    public void subcribed(String viberId)
    {
        User user = userRep.findByViberId(viberId);

        if (user != null)
        {
            user.setSubscribed(true);
            userRep.save(user);
        }
    }


    @Transactional
    public void unsubscribe(String viberId)
    {
        User user = userRep.findByViberId(viberId);
        if (user != null)
        {
            user.setSubscribed(false);
            userRep.save(user);
        }
    }

    public boolean findByViberId(String viberId)
    {
        if(userRep.findByViberId(viberId) != null)
            return false;

        return true;
    }
    public User findUser(String viberId) {

        return userRep.findByViberId(viberId);
    }
}