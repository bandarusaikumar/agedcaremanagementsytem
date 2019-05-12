package com.sim.agedcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sim.agedcare.entity.Doctor;
import com.sim.agedcare.repo.DoctorRepo;
import com.sim.agedcare.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorRepo doctorRepo;
	
	@Override
	public Doctor getDoctor(String username, String Password) {
		
		return doctorRepo.findByDoctorNameAndDoctorPassword(username, Password);
	}

	@Override
	public Doctor findByDoctorId(Long id) {
		return doctorRepo.getOne(id);
	}

	@Override
	public List<Doctor> getdoctors() {
		return doctorRepo.findAll();
	}

}
