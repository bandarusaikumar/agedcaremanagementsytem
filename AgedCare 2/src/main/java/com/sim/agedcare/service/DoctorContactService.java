package com.sim.agedcare.service;

import java.util.List;

import com.sim.agedcare.entity.DoctorContact;

public interface DoctorContactService {
	
	DoctorContact save(DoctorContact doctorContact);
	List<DoctorContact> getDoctorContacts();
	DoctorContact getDoctorContact(long id);
	List<DoctorContact> getPDoctorContacts(long paientId);
	List<DoctorContact> getDDoctorContacts(long doctorId);

	
}
