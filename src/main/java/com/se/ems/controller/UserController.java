package com.se.ems.controller;

import com.se.ems.dto.MedicalHistoryDto;
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

    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return  userService.getAllUsers();
    }

    @GetMapping("/byEmail")
    public UserDto getuser(@RequestParam String email) {
        return  userService.getUserByEmail(email);
    }

    @PutMapping("/update")
    public UserDto updateUser(@RequestBody UserDto user) {
        return userService.updateUser(user);
    }

    @PostMapping("/medical/history")
    public List<MedicalHistoryDto> saveMedicalHistory(@RequestBody  MedicalHistoryDto medicalHistoryDto) {
        return userService.saveMedicalHistory(medicalHistoryDto);
    }

    @GetMapping("/medical/history")
    public List<MedicalHistoryDto> getMedicalHistoryForuser(@RequestParam String userId) {
        return userService.getMedicalHistoryForuser(userId);
    }

}
