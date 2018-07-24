package com.edit.viberBot.service;

import com.edit.viberBot.model.User;
import com.edit.viberBot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRep;
}