package com.se.ems.services;

import com.se.ems.config.AppException;
import com.se.ems.dto.JwtResponse;
import com.se.ems.dto.LoginDto;
import com.se.ems.dto.UserDto;
import com.se.ems.entity.Doctor;
import com.se.ems.entity.User;
import com.se.ems.repository.UserRepo;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.print.Doc;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    JwtUtil jwtUtil;

    public UserDto saveUser(UserDto userdto){
        if(userRepo.existsByEmail(userdto.getEmail())){
            throw new AppException("Email already in use");
        }
        if ("DOCTOR".equalsIgnoreCase(userdto.getType())) {
            if (!Objects.nonNull(userdto.getSpecialty())) {
                throw new AppException("Special type needed for the Doctor");
            }
            if (!Objects.nonNull(userdto.getLicenseNumber())) {
                throw new AppException("License Number type needed for the Doctor");
            }
        }
        User user  = transformUserDtoUser(userdto);
        return transformUserDtoFromUser((User)userRepo.save(user));
    }

    public List<UserDto> getAllUsers(){
      return  userRepo.findAll().stream().map(this::transformUserDtoFromUser).toList();
    }

    private User transformUserDtoUser(UserDto userdto) {
        User user = new User();
        user.setFullname(userdto.getFullName());
        user.setPhoneNumber(userdto.getPhoneNumber());
        user.setEmail(userdto.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(userdto.getPassword()));
        user.setSpecialty(userdto.getSpecialty());
        user.setLicenseNumber(userdto.getLicenseNumber());
        user.setType(userdto.getType());
        return user;
    }

    private UserDto transformUserDtoFromUser(User userEn) {
        UserDto user = new UserDto();
        user.setId(userEn.getId());
        user.setFullName(userEn.getFullname());
        user.setPhoneNumber(userEn.getPhoneNumber());
        user.setEmail(userEn.getEmail());
        user.setType(userEn.getType());
        user.setLicenseNumber(userEn.getLicenseNumber());
        user.setSpecialty(userEn.getSpecialty());
        return user;
    }

    public JwtResponse login(LoginDto userdto) {
     User user =  userRepo.findByEmail(userdto.getEmail()).orElseThrow(()->new AppException("User not found"));
        if (!BCrypt.checkpw(userdto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("PassWord not matched");
        }
        return new JwtResponse(jwtUtil.generateToken(user.getEmail()),transformUserDtoFromUser(user));
    }
}
