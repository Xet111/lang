package com.ua.lang.service;

import com.ua.lang.dto.UserDTO;
import com.ua.lang.dto.UsersDTO;
import com.ua.lang.entity.User;
import com.ua.lang.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){this.userRepository = userRepository;}

    public UsersDTO getAllUsers() {
        return new UsersDTO(userRepository.findAll());
    }

    public Optional<User> findByUserLogin (UserDTO userDTO){
        return userRepository.findByFirstName(userDTO.getFirstName());
    }


    }

