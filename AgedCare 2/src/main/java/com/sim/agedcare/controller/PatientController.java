package com.sim.agedcare.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sim.agedcare.entity.AdminContact;
import com.sim.agedcare.entity.Doctor;
import com.sim.agedcare.entity.DoctorContact;
import com.sim.agedcare.entity.HealthRecord;
import com.sim.agedcare.entity.Patient;
import com.sim.agedcare.entity.PatientRelation;
import com.sim.agedcare.service.AdminContactService;
import com.sim.agedcare.service.DoctorContactService;
import com.sim.agedcare.service.DoctorService;
import com.sim.agedcare.service.HealthRecordService;
import com.sim.agedcare.service.LoginService;
import com.sim.agedcare.service.PatientService;
import com.sim.agedcare.vo.ContactAdmin;
import com.sim.agedcare.vo.ContactDoctor;
import com.sim.agedcare.vo.GetDocInfoBean;
import com.sim.agedcare.vo.PatientRelationBean;

@Controller
@ComponentScan(basePackages="com.sim.agedcare")
public class PatientController {
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	PatientService patientService;
	
	@Autowired
	AdminContactService adminContactService;
	
	@Autowired
	DoctorContactService doctorContactService;
	
	@Autowired
	HealthRecordService healthRecordService;
	
	@Autowired
	LoginService loginService;

	@Autowired
	DoctorService doctorService;
	
	@RequestMapping(value = { "/patienthome/{id}"}, method = RequestMethod.GET)
	public String PHomePage(Model model,@PathVariable("id") long id) {
		List<HealthRecord>  healthRecords= healthRecordService.getHealthRecords(id);
		List<GetDocInfoBean> getDocInfoBeans=healthRecordService.getDocInfoBeans(healthRecords); 
		System.out.println("getDocInfoBeans::"+getDocInfoBeans);
		model.addAttribute("getDocInfoBeans", getDocInfoBeans);
		Patient patient=patientService.getPatientById(id);		
		model.addAttribute("patient", patient);
		model.addAttribute("id", patient.getPatientId());
	    return "patient/patienthome"; 
	}
	
	@RequestMapping(value = { "/nursevisiting/{id}"}, method = RequestMethod.GET)
	public String pNursePage(Model model,@PathVariable("id") long id) {
		List<PatientRelation> patientRelations=patientService.getPatientRelationById(id);
		List<PatientRelationBean> patientRelationBeans=patientService.getPatientRelationBeans(patientRelations);
		log.info("patientRelationBeans::"+patientRelationBeans);
		model.addAttribute("patientRelationBeans", patientRelationBeans);
		Patient patient=patientService.getPatientById(id);		
		model.addAttribute("patient", patient);
		model.addAttribute("id", patient.getPatientId());
	    return "patient/pnursevisiting";
	}
	@RequestMapping(value = { "/admincontact/{id}"}, method = RequestMethod.GET)
	public String padmincontact(Model model,@PathVariable("id") long id) {
		List<AdminContact> adminContacts=adminContactService.getPAdminContacts(id);
		model.addAttribute("adminContacts", adminContacts);
		Patient patient=patientService.getPatientById(id);		
		model.addAttribute("patient", patient);
		model.addAttribute("id", patient.getPatientId());
	    return "patient/pviewcontactadmin";
	}
	@RequestMapping(value = { "/admincontactadd/{id}"}, method = RequestMethod.GET)
	public String padmincontact1(Model model,@PathVariable("id") long id) {
		Patient patient=patientService.getPatientById(id);		
		model.addAttribute("patient", patient);
		model.addAttribute("id", patient.getPatientId());
	    return "patient/pcontactadmin";
	}
	@RequestMapping(value = { "/pcontactadmin/{id}"}, method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String pcontactAdmin(Model model, ContactAdmin contactAdmin,@PathVariable("id") long id) {
		System.out.println(contactAdmin);
		AdminContact adminContact=new AdminContact();
		adminContact.setPatientMailId(contactAdmin.getPatientMailId());
		adminContact.setQuery(contactAdmin.getQuery());
		adminContact.setPatientId(id);
		adminContact.setPatientName(contactAdmin.getPatientName());
		adminContactService.save(adminContact);
		List<AdminContact> adminContacts=adminContactService.getPAdminContacts(id);		
		model.addAttribute("adminContacts", adminContacts);     
		Patient patient=patientService.getPatientById(id);		
		model.addAttribute("patient", patient);
		model.addAttribute("id", patient.getPatientId());
	    return "patient/pviewcontactadmin";
	}	
	/*@RequestMapping(value = { "/getinformationdoctor/{id}"}, method = RequestMethod.GET)
	public String pgetinformDoc(Model model,@PathVariable("id") long id) {		
		List<HealthRecord>  healthRecords= healthRecordService.getHealthRecords(id);
		List<GetDocInfoBean> getDocInfoBeans=healthRecordService.getDocInfoBeans(healthRecords); 
		System.out.println("getDocInfoBeans::"+getDocInfoBeans);
		model.addAttribute("getDocInfoBeans", getDocInfoBeans);
		Patient patient=patientService.getPatientById(id);		
		model.addAttribute("patient", patient);
		model.addAttribute("id", patient.getPatientId());
	    return "pviewhealthrecords";
	}*/
	@RequestMapping(value = { "/doctorcontact/{id}"}, method = RequestMethod.GET)
	public String pdoctorcontact(Model model,@PathVariable("id") long id) {
		List<DoctorContact> doctorContacts=doctorContactService.getPDoctorContacts(id);
		model.addAttribute("doctorContacts", doctorContacts);
		Patient patient=patientService.getPatientById(id);		
		model.addAttribute("patient", patient);
		model.addAttribute("id", patient.getPatientId());
	    return "patient/pviewcontactdoctor";
	}
	@RequestMapping(value = { "/doctorcontactadd/{id}"}, method = RequestMethod.GET)
	public String pdoctorcontact1(Model model,@PathVariable("id") long id) {
		Patient patient=patientService.getPatientById(id);
		List<Doctor> doctors=doctorService.getdoctors();
		model.addAttribute("doctors", doctors);
		model.addAttribute("patient", patient);
		model.addAttribute("id", patient.getPatientId());
	    return "patient/pcontactdoctor";
	}
	@RequestMapping(value = { "/pcontactdoctor/{id}"}, method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String pcontactDoctor(Model model, ContactDoctor contactDoctor,@PathVariable("id") long id) {
		log.info(""+contactDoctor);
		DoctorContact doctorContact=new DoctorContact();
		doctorContact.setPatientMailId(contactDoctor.getPatientMailId());
		doctorContact.setQuery(contactDoctor.getQuery());
		doctorContact.setPatientId(id);
		doctorContact.setPatientName(contactDoctor.getPatientName());
		doctorContact.setDoctorId(contactDoctor.getDoctorId());
		Doctor doctor=doctorService.findByDoctorId(contactDoctor.getDoctorId());
		doctorContact.setDoctorName(doctor.getDoctorName());
		doctorContactService.save(doctorContact);
		List<DoctorContact> doctorContacts=doctorContactService.getPDoctorContacts(id);		
		model.addAttribute("doctorContacts", doctorContacts);     
		Patient patient=patientService.getPatientById(id);		
		model.addAttribute("patient", patient);
		model.addAttribute("id", patient.getPatientId());
	    return "patient/pviewcontactdoctor";
	}	
	
	@RequestMapping(value = { "/savepatient"}, method = RequestMethod.POST)
	public String saveHealthRecord(Model model, Patient patient) {
		System.out.println(patient);
		log.info(""+patient);
		if(patient.getUserType().equalsIgnoreCase("D")) {
			patientService.saveDoctor(patient);
		}
		else {
			patientService.save(patient);
		}
	    return "login";
	}
}
