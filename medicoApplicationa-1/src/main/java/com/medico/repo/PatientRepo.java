package com.medico.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.medico.model.PatientDetails;

public interface PatientRepo extends MongoRepository<PatientDetails, Integer> {

}
