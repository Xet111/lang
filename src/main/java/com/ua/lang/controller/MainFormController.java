package com.ua.lang.controller;

import com.ua.lang.dto.UserDTO;
import com.ua.lang.dto.UsersDTO;
import com.ua.lang.entity.User;
import com.ua.lang.repository.UserRepository;
import com.ua.lang.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping(value = "/")
public class MainFormController{

    private final UserService userService;

    @Autowired
    public MainFormController(UserService userService) {
        this.userService = userService;
    }

   /* @ModelAttribute("users")
    public List<User> users(){
        return
    }
*//*
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "login")
    public void loginFormController(UserDTO user){
        log.info("{}",userService.findByUserLogin(user));
        log.info("{}", user);
    }
*/

}

