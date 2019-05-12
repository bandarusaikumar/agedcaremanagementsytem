package com.sim.agedcare.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sim.agedcare.entity.DoctorContact;

public interface DoctorContactRepo extends JpaRepository<DoctorContact, Long> {
	
	List<DoctorContact> findByPatientId(long patientId);
	List<DoctorContact> findByDoctorId(long doctorId);
	
	

}
