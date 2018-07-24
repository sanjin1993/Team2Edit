package com.edit.viberBot.controller;

import com.edit.viberBot.model.Admin;
import com.edit.viberBot.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;


    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public String admin()
    {
        Admin admin = new Admin();
        admin.setUsername("admin");
        admin.setPassword("password");
        adminRepository.save(admin);

        return "RouteViews/Index";
    }
}
