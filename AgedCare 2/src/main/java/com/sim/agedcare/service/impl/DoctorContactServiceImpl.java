package com.sim.agedcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sim.agedcare.entity.DoctorContact;
import com.sim.agedcare.repo.DoctorContactRepo;
import com.sim.agedcare.service.DoctorContactService;

@Service
public class DoctorContactServiceImpl implements DoctorContactService {

	@Autowired
	DoctorContactRepo doctorContactRepo;
	
	@Override
	public DoctorContact save(DoctorContact doctorContact) {		
		return doctorContactRepo.save(doctorContact);
	}

	@Override
	public List<DoctorContact> getDoctorContacts() {
		return doctorContactRepo.findAll();
	}

	@Override
	public DoctorContact getDoctorContact(long id) {	
		return doctorContactRepo.getOne(id);
	}

	@Override
	public List<DoctorContact> getPDoctorContacts(long patientId) {
		return doctorContactRepo.findByPatientId(patientId);
	}

	@Override
	public List<DoctorContact> getDDoctorContacts(long doctorId) {
		return doctorContactRepo.findByDoctorId(doctorId);
	}

}
