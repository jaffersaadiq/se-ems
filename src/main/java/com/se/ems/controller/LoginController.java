package com.se.ems.controller;

import com.se.ems.dto.UserDto;
import com.se.ems.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/se-ems/")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public String login(@RequestBody UserDto user) {
        return userService.login(user);
    }


}
