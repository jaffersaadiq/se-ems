package com.se.ems.repository;

import com.se.ems.entity.Hospitals;
import com.se.ems.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HospitalRepo extends MongoRepository<Hospitals, String> {
}
