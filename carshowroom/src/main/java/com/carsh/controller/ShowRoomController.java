package com.carsh.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.carsh.dto.CarRequest;
import com.carsh.model.ShowRoom;
import com.carsh.service.ShowRoomService;

@RestController
@RequestMapping("/api/showroom")
public class ShowRoomController {
	@Bean
	public RestTemplate getRest() {
		return new RestTemplate();
		
	}
	//@Autowired
	private RestTemplate rest =new RestTemplate();
	Logger LOGGER =  LoggerFactory.getLogger(ShowRoomController.class);
			
	@Autowired
	private ShowRoomService sSer;
//	
	static final String endpoint="http://localhost:8062/api-car/";
	@GetMapping("/viewcar/{id}")
	public String  getAllcars (@PathVariable int id) {
		
		ResponseEntity<CarRequest> response = rest.getForEntity(endpoint + "car/" + id, CarRequest.class);
		
		
		return response.getBody().toString();
//	CarRequest	 car =rest.exchange(endpoint+"car/"+id, HttpMethod.GET, null,CarRequest.class ).getBody();
//	return rest.getForObject(endpoint+"car/"+id, null, String.class);
	}
	
	@GetMapping("/wecome")
	public String  getWelcome () {
		return "welocme To Home Page";
	}
	
	
	
	@GetMapping("/show")
	public List<ShowRoom> getShowroomDetails(){
		LOGGER.info("accepted getSHowRoomDetails");
		List<ShowRoom> details = sSer.getAllShowRoom();
		return details;
	}
	@PostMapping("/addcar")
	public  String  addCar(@RequestBody CarRequest car) {
		return rest.postForObject(endpoint+"/add", car, String.class);
	}
	@PostMapping("/add")
	public String InsertDetails(@RequestBody ShowRoom sr) {
		LOGGER.info("accepted Insert Details ");
		ShowRoom s = sSer.addShowRoom(sr);
		String m ="";
		if(s!=null) {
			LOGGER.info(m);
			m ="successfully added ";
		} else
		{
			LOGGER.info(m);
			m= "No data Foud";
		}
		return m;
	}
	@PutMapping("/update")
	public  String  editDetails (@RequestBody ShowRoom shr) {
		LOGGER.info("accepted editDetails");
		sSer.updateShowRoom(shr);
		LOGGER.info("updated Record Successfully...");
		return "updated Record Successfully...";
		
	}
	@PutMapping("/upone/{sid}")
	public ShowRoom editOne(@RequestBody ShowRoom showroom ,@PathVariable int sid) {
		LOGGER.info("accepted editone ");
		return sSer.updateOne(showroom, sid);
		
	}
	@DeleteMapping("/delete")
	public String deleteDetails () {
		LOGGER.info("accepted DeleteDetails ");
		 sSer.deleteShowRoom();
		 LOGGER.info( "Deleted Record Successfully....");
		return "Deleted All Record Successfully....";
		
	}
	@DeleteMapping("/deleteone/{sid}")
	public String deleteOne(@PathVariable int sid) {
		LOGGER.info("accepted delete ");
		sSer.deleteShowRoomOne(sid);
		 LOGGER.info( "Deleted One Record Successfully....");
		return "Deleted Record Successfully...";
	}

	@GetMapping("/end")
	public String getEnPage() {
		return "This is end page rturn to Home";
	}
	
}
