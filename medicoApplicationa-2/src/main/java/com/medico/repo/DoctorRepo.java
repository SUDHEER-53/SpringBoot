package com.medico.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.medico.model.Doctor;
@Repository
public interface DoctorRepo extends MongoRepository<Doctor, Integer> {

}
