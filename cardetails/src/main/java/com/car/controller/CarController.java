package com.car.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.model.CarDetails;
import com.car.service.CarService;

@RestController
@RequestMapping("/api-car")
public class CarController {
	Logger LOGGER =LoggerFactory.getLogger(CarController.class);
	@Autowired
	private CarService cserv;
	
	
	@GetMapping("/home")
	public CarDetails getHome(@PathVariable int id ) {
		return cserv.getCarone(id);
	}
	
	@GetMapping("/all")
	public List<CarDetails> viewCardetails(){
		LOGGER.info("Accepted viewCardetails");
	List<CarDetails> carlist = 	cserv.getCar();
		return carlist;
	}   
	@GetMapping("/car/{id}")
	public CarDetails getCardetails(@PathVariable int id) {
		LOGGER.info("Accepted getCardetails");
		CarDetails car =cserv.getCarone( id);
		return car;
		
	}
	
     @PostMapping("/add")
	public String inserCardetails (@RequestBody CarDetails cardet ) {
    	 LOGGER.info("Accepted inserCardetails");
    	 CarDetails details =cserv.addCarDetails(cardet);
    	 String meg ="";
    	 if(details!=null) {
    		 LOGGER .error(meg);
    		 meg ="Successfully added";
    		 
    	 }
    	 else {
    		 LOGGER.error(meg);
    		 meg ="no details found ";
    	 }
    	 return meg;
	}
     @PutMapping("/update")
	public CarDetails updateDetails (@RequestBody CarDetails cardet){
    	 LOGGER.info("Accepted updateDetails");
		CarDetails car = cserv.updateDetails(cardet);
		return car ;
		
	}
     @PutMapping("/upone/{id}")
     public CarDetails updatecardetailsOne(@RequestBody  CarDetails cardeatils,@PathVariable  int id) {
    	 LOGGER.info("Accepted updatecardetailsOne");
    	 CarDetails car =cserv.updateOne(cardeatils, id);
    	 return car;
    	 
     }
     @DeleteMapping("/det")
     public String deleteDetails() {
    	 LOGGER.info("Accepted deleteDetails");
    	 cserv.deleteDetails();
    	 LOGGER.info("delete details Successfully");
    	 return "delete details Successfully";
     }
     @DeleteMapping("/delteone/{id}")
     public String deleteDetails (@PathVariable int id) {
    	 LOGGER.info("Accepted deleteDetails");
    	 cserv.deleteOne( id);
    	 LOGGER.info("Deleted record  successfully...");
    	 return "Deleted record  successfully...";
    	 
     }
	
}
