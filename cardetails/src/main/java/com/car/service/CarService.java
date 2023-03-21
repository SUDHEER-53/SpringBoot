package com.car.service;

import java.util.List;

import com.car.model.CarDetails;

public interface CarService {

	List<CarDetails> getCar();
	CarDetails addCarDetails(CarDetails addinfo);
	CarDetails updateDetails (CarDetails upadateinfo);
	CarDetails updateOne (CarDetails upadateOne, int id);
	void deleteDetails ();
	void deleteOne (int id);
	CarDetails getCarone( int id);
}
