package com.se.ems.repository;

import com.se.ems.entity.Hospitals;
import com.se.ems.entity.MedicalHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MedicalHistoryRepo extends MongoRepository<MedicalHistory, String> {
    List<MedicalHistory> findByUserId(String userId);
}
