package com.medico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medico.model.PatientDetails;
import com.medico.service.PatientService;

@RestController
public class PatientController {
	@Autowired
	private PatientService pser;
	@GetMapping("/get")
	public List<PatientDetails> getPatient(){
	return pser.getAllpatient();
		
	}
	@PostMapping("/post")
	public String registerPatient (@RequestBody PatientDetails pdetails) {
		pser.addPatient(pdetails);
		return "successfully added";
	}
	@PutMapping("/update")
	public PatientDetails updatePatientDet(@RequestBody PatientDetails pdet) {
		
		return pser.updatePatient(pdet);
	}
	@DeleteMapping("/delete/{id}")
	public String deletePatient (@PathVariable int id) {
		pser.deletePatient(id);
		return "delete patient successfully";
				
		
	}

}
