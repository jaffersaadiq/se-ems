package com.se.ems.services;

import com.se.ems.config.AppException;
import com.se.ems.dto.UserDto;
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

import java.util.List;

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
        User user  = transformUserDtoUser(userdto);
        return transformUserDtoFromUser((User)userRepo.save(user));
    }

    public List<UserDto> getAllUsers(){
      return  userRepo.findAll().stream().map(this::transformUserDtoFromUser).toList();
    }

    private User transformUserDtoUser(UserDto userdto) {
        User user = new User();
        user.setFirstName(userdto.getFirstName());
        user.setLastName(userdto.getLastName());
        user.setEmail(userdto.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(userdto.getPassword()));
        return user;
    }

    private UserDto transformUserDtoFromUser(User userEn) {
        UserDto user = new UserDto();
        user.setId(userEn.getId());
        user.setFirstName(userEn.getFirstName());
        user.setLastName(userEn.getLastName());
        user.setEmail(userEn.getEmail());
        return user;
    }

    public String login(UserDto userdto) {
     User user =  userRepo.findByEmail(userdto.getEmail()).orElseThrow(()->new AppException("User not found"));
        if (!BCrypt.checkpw(userdto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("PassWord not matched");
        }
        return jwtUtil.generateToken(user.getEmail());
    }
}
