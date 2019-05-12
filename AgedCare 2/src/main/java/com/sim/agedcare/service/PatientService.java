package com.sim.agedcare.service;

import java.util.List;

import com.sim.agedcare.entity.Doctor;
import com.sim.agedcare.entity.Patient;
import com.sim.agedcare.entity.PatientRelation;
import com.sim.agedcare.vo.PatientRelationBean;

public interface PatientService {
	
	
	Patient save(Patient patient);
	PatientRelation save(PatientRelation patientRelation);
	Patient getPatientById(Long id);
	List<Patient> getPatients();
	List<PatientRelation> getPatientRelationById(long Id);
	List<PatientRelation> getPatientRelations();
	void delete(long id);
	List<PatientRelationBean> getPatientRelationBeans(List<PatientRelation> patientRelations);
	Doctor saveDoctor(Patient patient);
	List<PatientRelation> getDoctorPatients(long id);
}
