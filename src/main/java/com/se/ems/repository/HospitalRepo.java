package com.se.ems.repository;

import com.se.ems.entity.Hospitals;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HospitalRepo extends MongoRepository<Hospitals, String> {
    List<Hospitals> findAllByZip(long zip);
    List<Hospitals> findTop100ByOrderByName();
}
