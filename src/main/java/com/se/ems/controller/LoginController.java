package com.se.ems.controller;

import com.se.ems.dto.JwtResponse;
import com.se.ems.dto.LoginDto;
import com.se.ems.dto.UserDto;
import com.se.ems.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/se-ems/")
@CrossOrigin("*")
public class LoginController {
    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public JwtResponse login(@RequestBody LoginDto user) {
        JwtResponse string =  userService.login(user);
        logger.info("Successful "+string.getToken());
        return string;
    }

    //TODO : Logout


}
