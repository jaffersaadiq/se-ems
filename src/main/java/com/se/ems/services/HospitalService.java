package com.se.ems.services;

import com.se.ems.dto.HospitalsDto;
import com.se.ems.entity.Hospitals;
import com.se.ems.repository.HospitalRepo;
import org.modelmapper.ModelMapper;
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


    public HospitalsDto transformDtoFromEntity(Hospitals source) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(source, HospitalsDto.class);
    }

    public Hospitals transformEntityfromDro(HospitalsDto hospitalEn) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(hospitalEn, Hospitals.class);

    }


    public HospitalsDto addHospital(HospitalsDto hospitalEn) {
        Hospitals hospitals = transformEntityfromDro(hospitalEn);
        hospitalRepo.save(hospitals);
        return transformDtoFromEntity(hospitals);
    }


    public List<HospitalsDto> addHospitals(List<HospitalsDto> hospitals) {
        return hospitalRepo.saveAll(hospitals.stream().map(this::transformEntityfromDro).toList()).stream().map(this::transformDtoFromEntity).toList();
    }

    public List<HospitalsDto> getHospitalbyzip(Long zip) {
     return    hospitalRepo.findAllByZip(zip).stream().map(this::transformDtoFromEntity).toList();
    }
}
