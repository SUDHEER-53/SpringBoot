package com.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.model.CarDetails;
import com.car.repo.CarRepo;
@Service
public class CarServiceImpl implements CarService{
	@Autowired
	private CarRepo carRepo;
	@Override
	public List<CarDetails> getCar() {
		
		return carRepo.findAll();
	}

	@Override
	public CarDetails addCarDetails(CarDetails addinfo) {
		
		return carRepo.insert(addinfo);
	}

	@Override
	public CarDetails updateDetails(CarDetails upadateinfo) {
		
		return carRepo.save(upadateinfo);
	}

	@Override
	public CarDetails updateOne(CarDetails upadateOne, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDetails() {
		carRepo.deleteAll();
		
	}

	@Override
	public void deleteOne( int id) {
		carRepo.deleteById(id);
		
	}

	@Override
	public CarDetails getCarone( int id) {
		CarDetails  ca =carRepo.findById(id).get();
		return ca;
	}

}
