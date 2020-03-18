package com.ua.lang.service;

import com.ua.lang.dto.UserDTO;
import com.ua.lang.dto.UsersDTO;
import com.ua.lang.entity.User;
import com.ua.lang.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Slf4j
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    //public UserService(UserRepository userRepository){this.userRepository = userRepository;}

    public UsersDTO getAllUsers() {
        return new UsersDTO(userRepository.findAll());
    }

    public Optional<User> findByUserLogin (UserDTO userDTO){
        return userRepository.findByFirstName(userDTO.getUsername());
    }

    @PostConstruct
    public void init(){
        userRepository.findByUsername("user").ifPresent(user -> {
            user.setPassword(new BCryptPasswordEncoder().encode("password"));
            userRepository.save(user);
        });


        }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserDTO(userRepository.findByUsername(username).orElseThrow(() ->
        new UsernameNotFoundException("user"+ username+" was not found")));

    }
}

