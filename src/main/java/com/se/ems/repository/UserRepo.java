package com.se.ems.repository;

import com.se.ems.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User, String> {
   //Select user from User user where email=:email
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

}
