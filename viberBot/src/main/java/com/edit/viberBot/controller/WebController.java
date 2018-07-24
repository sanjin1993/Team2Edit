package com.edit.viberBot.controller;

import com.edit.viberBot.model.Admin;
import com.edit.viberBot.repository.AdminRepository;
import com.edit.viberBot.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class WebController {

    @Autowired
    AdminRepository repository;

    @Autowired
    RouteRepository routeRepository;


    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String Home(Model model, HttpSession session)
    {
        return "Layout/Header";
    }
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String Logout(Model model, HttpSession session)
    {
        session.setAttribute("userId" , null);
        session.setAttribute("username" , null  );
        model.addAttribute("admin",new Admin());
        return "Login";
    }
    @RequestMapping(value = {"/login","/"},method = RequestMethod.GET)
    public String Login(Model model, HttpSession session)
    {
        if (session.getAttribute("userId") != null)
        {
            return "redirect:/findAll";
        }

        model.addAttribute("admin",new Admin());
        return "Login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String postLogin (@RequestParam("username") String username ,@RequestParam("password")String password  , Model model, HttpSession session)
    {
      System.out.println(username);
      Admin test = repository.findByUsername(username);

      if ( test != null)
      {
          session.setAttribute("userId" , test.getId());
          session.setAttribute("username",test.getUsername());

          model.addAttribute("routes" ,routeRepository.findAll());

          return "RouteViews/Index";
      }
      return "Login";
    }



}
