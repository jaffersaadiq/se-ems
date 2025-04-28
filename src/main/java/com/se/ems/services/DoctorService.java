package com.se.ems.services;

import com.se.ems.dto.DoctorDto;
import com.se.ems.entity.Doctor;
import com.se.ems.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

//    @Autowired
//    DoctorRepo doctorRepo;

//    public Doctor saveDoctor(Doctor doctor){
//        return doctorRepo.save(doctor);
//    }
//
//    public DoctorDto saveDoctor(DoctorDto doctorDto){
//        Doctor doctor = new Doctor();
//        doctor.setEmail(doctorDto.getEmail());
//        doctor.setFullname(doctorDto.getFullname());
//        doctor.setPassword(new BCryptPasswordEncoder().encode(doctorDto.getPassword()));
//        doctor.setLicenseNumber(doctorDto.getLicenseNumber());
//        doctor.setSpecialty(doctorDto.getSpecialty());
//        doctor.setPhoneNumber(doctorDto.getPhoneNumber());
//       return doctorDto;
//    }



}
