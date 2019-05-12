package com.sim.agedcare.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sim.agedcare.entity.AdminContact;
import com.sim.agedcare.entity.Doctor;
import com.sim.agedcare.entity.HealthRecord;
import com.sim.agedcare.entity.Nurse;
import com.sim.agedcare.entity.Patient;
import com.sim.agedcare.entity.PatientRelation;
import com.sim.agedcare.service.AdminContactService;
import com.sim.agedcare.service.DoctorService;
import com.sim.agedcare.service.HealthRecordService;
import com.sim.agedcare.service.LoginService;
import com.sim.agedcare.service.PatientService;
import com.sim.agedcare.vo.ContactAdmin;
import com.sim.agedcare.vo.PatientRelationBean;

@Controller
@ComponentScan(basePackages="com.sim.agedcare")
public class AdminController {
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	public static int HEALTH_COUNT=0;
	
	@Autowired
	DoctorService doctorService;
	
	@Autowired
	PatientService patientService;
	
	@Autowired
	AdminContactService adminContactService;
	
	@Autowired
	HealthRecordService healthRecordService;
	
	@Autowired
	LoginService loginService;		
	
	 @Autowired
	 public JavaMailSender sender;
	 
	 /*
	  * 
	  */
	@RequestMapping(value = { "/adminhome"}, method = RequestMethod.GET)
	public String aHomePage(Model model) {
		List<Patient> patients=patientService.getPatients();		
		model.addAttribute("patients", patients);
	    return "admin/adminhome"; 
	}
	
	
	@RequestMapping(value = { "/nursevisiting"}, method = RequestMethod.GET)
	public String nursePage(Model model) {
		List<PatientRelation> patientRelations=patientService.getPatientRelations();
		
		List<PatientRelationBean> patientRelationBeans=patientService.getPatientRelationBeans(patientRelations);
		log.info("patientRelationBeans::"+patientRelationBeans);
		model.addAttribute("patientRelationBeans", patientRelationBeans);
	    return "admin/nursevisiting";
	}
	
	@RequestMapping(value = { "/admincontact"}, method = RequestMethod.GET)
	public String admincontact(Model model) {
		List<AdminContact> adminContacts=adminContactService.getAdminContacts();
		model.addAttribute("adminContacts", adminContacts);
	    return "admin/viewcontactadmin";
	}
		
	@RequestMapping(value = { "/contactadminedit"}, method = RequestMethod.GET)
	public String admincontactedit(Model model,@RequestParam("caid") long caid,ContactAdmin contactAdmin) {
		AdminContact adminContact=adminContactService.getAdminContact(caid);				
		model.addAttribute("adminContact", adminContact);
	    return "admin/contactadmin";
	}	
	@RequestMapping(value = { "/contactadmin/{adid}"}, method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String contactAdmin(Model model, ContactAdmin contactAdmin,@PathVariable("adid") String adid) {
		System.out.println(contactAdmin);
		AdminContact adminContact=adminContactService.getAdminContact(Long.parseLong(adid));		
		adminContact.setAnswer(contactAdmin.getAnswer());
		adminContactService.save(adminContact);
		List<AdminContact> adminContacts=adminContactService.getAdminContacts();
		model.addAttribute("adminContacts", adminContacts);
		model.addAttribute("adid", adid);
		MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(adminContact.getPatientMailId());
            helper.setText(contactAdmin.getAnswer());
            helper.setSubject(adminContact.getQuery());
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error while sending mail ..";
        }
       // sender.send(message);
        		
	    return "admin/viewcontactadmin";
	}
	@RequestMapping(value = { "/getinformationdoctor"}, method = RequestMethod.GET)
	public String getinformDoc(Model model) {		
		List<HealthRecord>  healthRecords= healthRecordService.getHealthRecords();
		model.addAttribute("healthRecords", healthRecords);		
	    return "admin/viewhealthrecords";
	}
	@RequestMapping(value="/deletenursevisit/{id}",method=RequestMethod.GET)
	String deleteNurseVisit(@PathVariable("id") int id,Model model)throws Exception{
		patientService.delete(id);
		List<PatientRelation> patientRelations=patientService.getPatientRelations();	
	List<PatientRelationBean> patientRelationBeans=patientService.getPatientRelationBeans(patientRelations);
		
		model.addAttribute("patientRelationBeans", patientRelationBeans);
		//model.addAttribute("patientRelations", patientRelations);
	    return "admin/nursevisiting";
	}

	@RequestMapping(value = { "/savenursevisit"}, method = RequestMethod.POST)
	public String savNurseVisit(Model model, PatientRelation patientRelation) {
		System.out.println(patientRelation);
		UUID uuid = UUID.randomUUID();
		HealthRecord healthRecord = new HealthRecord();
		healthRecord.setHealthId(uuid.getLeastSignificantBits());
		healthRecord.setMedicare("Care");
		healthRecord.setPatientId(patientRelation.getPatientId());
		healthRecord.setDoctorId(patientRelation.getDoctorId());
		healthRecord.setNurseId(patientRelation.getNurseId());
		if(HEALTH_COUNT%2==0) {			
			healthRecord.setHealthInfo("Good");
			healthRecord.setHealthSummary("Fine");
			healthRecord.setAge(30);
			healthRecord.setClaims("No Claims");
			healthRecord.setEmergencyContact(345345435);
		}else {
			healthRecord.setHealthInfo("Average");
			healthRecord.setHealthSummary("Good");
			healthRecord.setAge(40);
			healthRecord.setClaims("One Claim");
			healthRecord.setEmergencyContact(5454545);
		}
		healthRecordService.save(healthRecord);
		HEALTH_COUNT++;
		patientRelation.setNurseVisitingDate(new Date());
		patientService.save(patientRelation);
		List<PatientRelation> patientRelations=patientService.getPatientRelations();	
List<PatientRelationBean> patientRelationBeans=patientService.getPatientRelationBeans(patientRelations);
		
		model.addAttribute("patientRelationBeans", patientRelationBeans);
		model.addAttribute("patientRelations", patientRelations);
	    return "admin/nursevisiting";
	}
	@RequestMapping(value = { "/nursevisit/addnursevisit"}, method = RequestMethod.GET)
	public String addNurseVisit(Model model) {
		List<Doctor> doctors=loginService.getdoctors();
		List<Nurse> nurses=loginService.getNurses();
		List<Patient> patients=loginService.getPatients();
		model.addAttribute("doctors", doctors);
		model.addAttribute("nurses", nurses);
		model.addAttribute("patients", patients);
	    return "admin/addnursevisit"; 
	}
	@RequestMapping(value = { "/savehealthrecord"}, method = RequestMethod.POST)
	public String saveHealthRecord(Model model, HealthRecord healthRecord) {
		System.out.println(healthRecord);
		healthRecordService.save(healthRecord);
		List<HealthRecord>  healthRecords= healthRecordService.getHealthRecords();
		model.addAttribute("healthRecords", healthRecords);		
	    return "admin/viewhealthrecords";
	}
	@RequestMapping(value="/deletehealthrecord/{id}",method=RequestMethod.GET)
	String delete(@PathVariable("id") int id,Model model)throws Exception{		
		healthRecordService.delete(id);
		List<HealthRecord>  healthRecords= healthRecordService.getHealthRecords();
		model.addAttribute("healthRecords", healthRecords);		
	    return "admin/viewhealthrecords";
	}
}
