package com.ua.lang.controller;

import com.ua.lang.entity.User;
import com.ua.lang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class PageController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = {"/","/index"})
    public String mainPage(Model model){
        model.addAttribute("users",userRepository.findAll());
        return "index";
    }
/*
    @GetMapping("/index")
    public ModelAndView showUsers() {

        List<User> users = userRepository.findAll();

        Map<String, Object> params = new HashMap<>();
        params.put("users", users);

        return new ModelAndView("users", params);
    }*/
    /*@ModelAttribute("user")
    public List<User> messages() {
        return userRepository.findAll();
    }*/



}
