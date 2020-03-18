package com.ua.lang.repository;

import com.ua.lang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByFirstName(String firstName);
    Optional<User> findByUsername(String username);
}

