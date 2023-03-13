package com.medico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.medico.model.Doctor;
import com.medico.service.DoctorService;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
	@Autowired
	private DoctorService dservice;
	@GetMapping("/details")
	@ResponseStatus(HttpStatus.OK)
	public List<Doctor> getDrdetails(){
		return dservice.getDoctor();
		
	}
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public String addDrdetails(@RequestBody Doctor doctor) {
		dservice.addDoctor(doctor);
		return "Add doctor successfully";
	}
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public Doctor updateDrDetails(@RequestBody Doctor  drupdate) {
		return dservice.upDoctor(drupdate);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String deleteDr(@PathVariable int id) {
		dservice.deleteDoctor(id);
		return "doctor remove details Successfully";
	}
	

}
