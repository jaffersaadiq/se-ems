package com.se.ems.services;

import com.se.ems.config.AppException;
import com.se.ems.dto.JwtResponse;
import com.se.ems.dto.LoginDto;
import com.se.ems.dto.MedicalHistoryDto;
import com.se.ems.dto.UserDto;
import com.se.ems.entity.MedicalHistory;
import com.se.ems.entity.User;
import com.se.ems.repository.MedicalHistoryRepo;
import com.se.ems.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
    @Autowired
    private MedicalHistoryRepo medicalHistoryRepo;

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
    
    public UserDto getUserByEmail(String email){
        return transformUserDtoFromUser(userRepo.findByEmail(email).orElseThrow(()->new AppException("User not found")));
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
        user.setGender(userEn.getGender());
        user.setAllergies(userEn.getAllergies());
        user.setEmergencyContact(userEn.getEmergencyContact());
        user.setAge(userEn.getAge());
        user.setBlood(userEn.getBlood());
        return user;
    }

    public JwtResponse login(LoginDto userdto) {
     User user =  userRepo.findByEmail(userdto.getEmail()).orElseThrow(()->new AppException("User not found"));
        if (!BCrypt.checkpw(userdto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("PassWord not matched");
        }
        return new JwtResponse(jwtUtil.generateToken(user.getEmail()),transformUserDtoFromUser(user));
    }

    public UserDto updateUser(UserDto userdto){
        User user =  userRepo.findByEmail(userdto.getEmail()).orElseThrow(()->new AppException("User not found"));

        if ("DOCTOR".equalsIgnoreCase(userdto.getType())) {
            if (!Objects.nonNull(userdto.getSpecialty())) {
                throw new AppException("Special type needed for the Doctor");
            }
            if (!Objects.nonNull(userdto.getLicenseNumber())) {
                throw new AppException("License Number type needed for the Doctor");
            }
        }
        user.setFullname(userdto.getFullName());
        user.setPhoneNumber(userdto.getPhoneNumber());
        user.setSpecialty(userdto.getSpecialty());
        user.setLicenseNumber(userdto.getLicenseNumber());
        user.setType(userdto.getType());
        user.setGender(userdto.getGender());
        user.setAllergies(userdto.getAllergies());
        user.setEmergencyContact(userdto.getEmergencyContact());
        user.setSpecialty(userdto.getSpecialty());
        user.setLicenseNumber(userdto.getLicenseNumber());
        user.setAge(userdto.getAge());
        user.setBlood(userdto.getBlood());
        return transformUserDtoFromUser((User)userRepo.save(user));
    }

    public List<MedicalHistoryDto> saveMedicalHistory(List<MedicalHistoryDto> medicalhistorydto){
        return  medicalHistoryRepo.saveAll(medicalhistorydto.stream()
                .map(this::transforMedicalHistoryEntity).toList()).stream().map(this::transforMedicalHistory).toList();
    }


    public List<MedicalHistoryDto> getMedicalHistoryForuser(String userId){
        return medicalHistoryRepo.findByUserId(userId).stream().map(this::transforMedicalHistory).toList();
    }
    public MedicalHistoryDto transforMedicalHistory(MedicalHistory medicalhistory){
        MedicalHistoryDto dto = new MedicalHistoryDto();
        dto.setId(medicalhistory.getId());
        dto.setUserId(medicalhistory.getUserId());
        dto.setName(medicalhistory.getName());
        dto.setValue(medicalhistory.getValue());
        return dto;
    }

    public MedicalHistory transforMedicalHistoryEntity(MedicalHistoryDto medicalHistoryDto){
        if(medicalHistoryDto.getName()==null||medicalHistoryDto.getValue()==null){
            throw new AppException("Medical History  or Value is null");
        }
        MedicalHistory entity = new MedicalHistory();
        entity.setUserId(medicalHistoryDto.getUserId());
        entity.setName(medicalHistoryDto.getName());
        entity.setValue(medicalHistoryDto.getValue());
        return entity;
    }

}
