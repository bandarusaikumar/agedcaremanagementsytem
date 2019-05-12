package com.sim.agedcare.service;

import java.util.List;

import com.sim.agedcare.entity.Doctor;

public interface DoctorService {
	
	public Doctor getDoctor(String username,String Password);
	Doctor findByDoctorId(Long id);
	List<Doctor> getdoctors();

}
