package com.se.ems.services;

import com.se.ems.dto.HospitalsDto;
import com.se.ems.entity.Hospitals;
import com.se.ems.repository.HospitalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {
    @Autowired
    HospitalRepo hospitalRepo;

    public List<HospitalsDto> getAllHospitals() {
        return hospitalRepo.findAll().stream().map(this::transformDtoFromEntity).toList();
    }


    public HospitalsDto transformDtoFromEntity(Hospitals hospitals) {
        HospitalsDto hospitalsDto = new HospitalsDto();
        hospitalsDto.setId(hospitals.getId());
        hospitalsDto.setName(hospitals.getName());
        hospitalsDto.setAddress(hospitals.getAddress());
        hospitalsDto.setPhone(hospitals.getPhone());
        hospitalsDto.setDistance(hospitals.getDistance());
        return hospitalsDto;
    }

    public Hospitals transformEntityfromDro(HospitalsDto hospitalEn) {
        Hospitals hospital = new Hospitals();
        hospital.setName(hospitalEn.getName());
        hospital.setAddress(hospitalEn.getAddress());
        hospital.setPhone(hospitalEn.getPhone());
        hospital.setDistance(hospitalEn.getDistance());
        hospital.setId(hospitalEn.getId());
        return hospital;
    }


    public HospitalsDto addHospital(HospitalsDto hospitalEn) {
        return transformDtoFromEntity(hospitalRepo.save(transformEntityfromDro(hospitalEn)));
    }


}
