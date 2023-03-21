package com.carsh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.carsh.dto.CarRequest;
import com.carsh.model.ShowRoom;
import com.carsh.service.ShowRoomService;

@RestController
public class ShowRoomController {
	@Bean
	public RestTemplate getRest() {
		return new RestTemplate();
		
	}
	@Autowired
	private RestTemplate rest =new RestTemplate();
	//@Autowired
	private ShowRoomService sSer;
	
	static final String endpoint="http://localhost:8062/api-car/";
	@GetMapping("/show")
	public String  getAllcars (@PathVariable int id) {
	CarRequest	 car =rest.exchange(endpoint+"car/"+id, HttpMethod.GET, null,CarRequest.class ).getBody();
	return rest.getForObject(endpoint+"car/"+id, null, String.class);
	}
	
	@GetMapping("")
	public List<ShowRoom> getShowroomDetails(){
		
		List<ShowRoom> details = sSer.getAllShowRoom();
		return details;
	}
	@PostMapping("/addcar")
	public  String  addCar(@RequestBody CarRequest car) {
		return rest.postForObject(endpoint+"/add", car, String.class);
	}
	@PostMapping("")
	public String InsertDetails(@RequestBody ShowRoom sr) {
		ShowRoom s = sSer.addShowRoom(sr);
		String m ="";
		if(s!=null) {
			m ="successfully added ";
		} else
		{
			m= "No data Foud";
		}
		return m;
	}
	@PutMapping("/update")
	public  String  editDetails (@RequestBody ShowRoom shr) {
		sSer.updateShowRoom(shr);
		
		return "updated Record Successfully...";
		
	}
	@PutMapping("/upone/{sid}")
	public ShowRoom editOne(@RequestBody ShowRoom showroom ,@PathVariable int sid) {
		ShowRoom shr =sSer.updateOne(showroom, sid);
		return shr;
	}
	@DeleteMapping("/delete")
	public String deleteDetails () {
	
		 sSer.deleteShowRoom();
		return "Deleted Record Successfully....";
		
	}
	@DeleteMapping("/deleteone/{sid}")
	public String deleteOne(@PathVariable int sid) {
		sSer.deleteShowRoomOne(sid);
		
		return "Deleted Record Successfully...";
	}

	
}
