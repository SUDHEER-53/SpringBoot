package com.medico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.model.Doctor;
import com.medico.repo.DoctorRepo;

@Service
public class DoctorService {
	@Autowired
	private DoctorRepo drepo;
	
	public List<Doctor> getDoctor(){
		return drepo.findAll();
		
	}
	public void addDoctor(Doctor doctor) {
		drepo.save(doctor);
	}
	public Doctor upDoctor(Doctor doctor) {
		return drepo.save(doctor);
		
	}
	
     public void deleteDoctor(int id) {
	drepo.deleteById(id);
}
}
