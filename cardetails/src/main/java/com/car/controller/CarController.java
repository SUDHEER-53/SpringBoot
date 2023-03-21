package com.car.controller;

import java.util.List;

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
@RequestMapping("api-car")
public class CarController {
	@Autowired
	private CarService cserv;
	
	
	@GetMapping("/all")
	public List<CarDetails> viewCardetails(){
	List<CarDetails> carlist = 	cserv.getCar();
		return carlist;
	}   
	@GetMapping("/car/{id}")
	public CarDetails getCardetails(@PathVariable int id) {
		CarDetails car =cserv.getCarone( id);
		return car;
		
	}
	
     @PostMapping("/add")
	public String inserCardetails (@RequestBody CarDetails cardet ) {
    	 CarDetails details =cserv.addCarDetails(cardet);
    	 String meg ="";
    	 if(details!=null) {
    		 meg ="Successfully added";
    	 }
    	 else {
    		 meg ="no details found ";
    	 }
    	 return meg;
	}
     @PutMapping("/update")
	public CarDetails updateDetails (@RequestBody CarDetails cardet){
		
		CarDetails car = cserv.updateDetails(cardet);
		return car ;
		
	}
     @PutMapping("/upone/{id}")
     public CarDetails updatecardetailsOne(@RequestBody  CarDetails cardeatils,@PathVariable  int id) {
    	 CarDetails car =cserv.updateOne(cardeatils, id);
    	 return car;
    	 
     }
     @DeleteMapping("/det")
     public String deleteDetails() {
    	 cserv.deleteDetails();
    	 
    	 return "delete details Successfully";
     }
     @DeleteMapping("/delteone/{id}")
     public String deleteDetails (@PathVariable int id) {
    	 cserv.deleteOne( id);
    	 return "Deleted record  successfully...";
    	 
     }
	
}
