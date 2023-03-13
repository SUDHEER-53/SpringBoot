package com.medico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.model.PatientDetails;
import com.medico.repo.PatientRepo;

@Service
public class PatientService {
	@Autowired
	private PatientRepo prepo;
	
	

	
	public List<PatientDetails> getAllpatient(){
		return prepo.findAll();
	}
	public void addPatient(PatientDetails patientDetails) {
		prepo.save(patientDetails);
		
		}
	public PatientDetails updatePatient(PatientDetails patientUpdate ) {
		return prepo.save(patientUpdate);
		
	}
	public void deletePatient(int id) {
		prepo.deleteById(id);
		
	}
}

