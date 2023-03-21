package com.car.repo;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.car.model.CarDetails;

public interface CarRepo extends MongoRepository<CarDetails, Integer> {

}
