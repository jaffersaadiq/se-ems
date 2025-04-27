package com.se.ems.controller;


import com.se.ems.dto.HospitalsDto;
import com.se.ems.entity.Hospitals;
import com.se.ems.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/se-ems/hospital")
@CrossOrigin("*")
public class HospitalsController {

    @Autowired
    HospitalService hospitalService;
    @GetMapping("")
    public List<HospitalsDto>  getHospitals(){
        return hospitalService.getAllHospitals();
    }

    @PostMapping("/")
    public HospitalsDto addHospital(@RequestBody HospitalsDto hospital){
        return hospitalService.addHospital(hospital);
    }
}
