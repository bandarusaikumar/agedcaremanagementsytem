package com.sim.agedcare.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sim.agedcare.entity.Doctor;
import com.sim.agedcare.entity.Patient;
import com.sim.agedcare.entity.PatientRelation;
import com.sim.agedcare.entity.User;
import com.sim.agedcare.repo.DoctorRepo;
import com.sim.agedcare.repo.NurseRepo;
import com.sim.agedcare.repo.PatientRelationRepo;
import com.sim.agedcare.repo.PatientRepository;
import com.sim.agedcare.repo.UserRepo;
import com.sim.agedcare.service.PatientService;
import com.sim.agedcare.vo.PatientRelationBean;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	PatientRelationRepo patientRelationRepo;
	
	@Autowired
	DoctorRepo doctorRepo;
	
	@Autowired
	NurseRepo nurseRepo;
	
	@Autowired
	UserRepo userRepo;
	
	
	@Override
	public Patient getPatientById(Long id) {		
		return patientRepository.getOne(id);
	}

	@Override
	public List<Patient> getPatients() {
		
		return patientRepository.findAll();
	}

	@Override
	public List<PatientRelation> getPatientRelationById(long Id) {
		return patientRelationRepo.findByPatientId(Id);
	}

	@Override
	public List<PatientRelation> getPatientRelations() {
		return patientRelationRepo.findAll() ;
	}

	@Override
	public Patient save(Patient patient) {
		
		User user=new User();
		user.setUsername(patient.getPatientName());
		user.setPassword(patient.getPatientPassword());
		user.setUserType("P");
		userRepo.save(user);
		return patientRepository.save(patient);
	}

	@Override
	public PatientRelation save(PatientRelation patientRelation) {
		return patientRelationRepo.save(patientRelation) ;
	}

	@Override
	public void delete(long id) {
		patientRelationRepo.deleteById(id);		
	}

	@Override
	public List<PatientRelationBean> getPatientRelationBeans(List<PatientRelation> patientRelations) {
		List<PatientRelationBean> patientRelationBeans=new ArrayList<>();
		PatientRelationBean patientRelationBean=null;
		Iterator<PatientRelation> it=patientRelations.iterator();
		while (it.hasNext()) {
			PatientRelation patientRelation = (PatientRelation) it.next();
			patientRelationBean=new PatientRelationBean();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");  
			Date d=patientRelation.getNurseVisitingDate();			
			patientRelationBean.setNurseVisitingDate(formatter.format(d));
			patientRelationBean.setReason(patientRelation.getReason());
			patientRelationBean.setDoctorName(doctorRepo.getOne(patientRelation.getDoctorId()).getDoctorName());
			patientRelationBean.setNuirseName(nurseRepo.getOne(patientRelation.getNurseId()).getName());
			patientRelationBean.setPatientName(patientRepository.getOne(patientRelation.getPatientId()).getPatientName());
			patientRelationBean.setPat_relationId(patientRelation.getPat_relationId());
			patientRelationBeans.add(patientRelationBean);
		}		
		return patientRelationBeans;
	}

	@Override
	public Doctor saveDoctor(Patient patient) {
		Doctor doctor=new Doctor();
		doctor.setDoctorAddress(patient.getPatientaddress());
		doctor.setDoctorAge(patient.getPatientage());
		doctor.setDoctorContactnumber(patient.getPatientContactnumber());
		doctor.setDoctorEmail(patient.getPatientemail());
		doctor.setDoctorName(patient.getPatientName());
		doctor.setDoctorPassword(patient.getPatientPassword());
		doctor.setInfo("Very Good");	
		
		User user=new User();
		user.setUsername(patient.getPatientName());
		user.setPassword(patient.getPatientPassword());
		user.setUserType("D");
		userRepo.save(user);
		return doctorRepo.save(doctor);
	}

	@Override
	public List<PatientRelation> getDoctorPatients(long id) {
		
		return patientRelationRepo.findByDoctorId(id);
	}

}
