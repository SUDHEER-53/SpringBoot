package com.car.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.model.CarDetails;
import com.car.repo.CarRepo;
@Service
public class CarServiceImpl implements CarService{
	Logger LOGGER =LoggerFactory.getLogger(CarServiceImpl.class);
	@Autowired
	private CarRepo carRepo;
	@Override
	public List<CarDetails> getCar() {
		LOGGER.info("Accepted getCar ");
		return carRepo.findAll();
	}

	@Override
	public CarDetails addCarDetails(CarDetails addinfo) {
		LOGGER.info("Accepted addCarDetails ");
		return carRepo.insert(addinfo);
	}

	@Override
	public CarDetails updateDetails(CarDetails upadateinfo) {
		LOGGER.info("Accepted updateDetails ");
		return carRepo.save(upadateinfo);
	}

	@Override
	public CarDetails updateOne(CarDetails upadateOne, int id) {
		LOGGER.info("Accepted updateOne ");
		CarDetails car = carRepo.save( upadateOne);
		return car ;
	}

	@Override
	public void deleteDetails() {
		LOGGER.info("Accepted deleteDetails ");
		carRepo.deleteAll();
		
	}

	@Override
	public void deleteOne( int id) {
		LOGGER.info("Accepted deleteOne ");
		carRepo.deleteById(id);
		
	}

	@Override
	public CarDetails getCarone( int id) {
		LOGGER.info("Accepted getCarone ");
		CarDetails  ca =carRepo.findById(id).get();
		return ca;
	}

}
