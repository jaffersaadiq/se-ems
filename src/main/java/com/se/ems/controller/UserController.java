package com.se.ems.controller;

import com.se.ems.dto.UserDto;
import com.se.ems.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/se-ems/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public UserDto createUser(@RequestBody @Valid UserDto user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return  userService.getAllUsers();
    }

}
