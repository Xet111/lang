package com.ua.lang.controller;

import com.ua.lang.dto.UserDTO;
import com.ua.lang.entity.RoleType;
import com.ua.lang.entity.User;
import com.ua.lang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.joining;


@Controller
public class PageController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = {"/","/index"})
    public String mainPage(Model model){
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();
        UserDTO user = (UserDTO) authentication.getPrincipal();

        model.addAttribute("username",user.getUsername());
        model.addAttribute("role",user.getAuthorities());
        model.addAttribute("users",userRepository.findAll());
        return "index";
    }
    @RequestMapping(value = "/admin")
    public String adminPage(Model model){
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();
        UserDTO user =(UserDTO) authentication.getPrincipal();
        model.addAttribute("user",user.getUsername());

        return "admin";
    }

    @RequestMapping(value = {"/menu"})
    public String menuPage(Model model){
        model.addAttribute("users",userRepository.findAll());
        return "menu";
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
