package com.sim.agedcare.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

import com.sim.agedcare.entity.Doctor;
import com.sim.agedcare.entity.DoctorContact;
import com.sim.agedcare.entity.HealthRecord;
import com.sim.agedcare.entity.Patient;
import com.sim.agedcare.entity.PatientRelation;
import com.sim.agedcare.service.DoctorContactService;
import com.sim.agedcare.service.DoctorService;
import com.sim.agedcare.service.HealthRecordService;
import com.sim.agedcare.service.PatientService;
import com.sim.agedcare.vo.ContactDoctor;
import com.sim.agedcare.vo.GetDocInfoBean;
import com.sim.agedcare.vo.PatientRelationBean;

@Controller
@ComponentScan(basePackages="com.sim.agedcare")
public class DoctorController {
	
	private static final Logger log = LoggerFactory.getLogger(DoctorController.class);
	
	@Autowired
	DoctorService doctorService;
	
	@Autowired
	PatientService patientService;
	
	@Autowired
	HealthRecordService healthRecordService;
	
	@Autowired
	DoctorContactService doctorContactService;
	
	@Autowired
	public JavaMailSender sender;
	
	@RequestMapping(value = { "/doctorhome/{id}"}, method = RequestMethod.GET)
	public String dHomePage(Model model,@PathVariable("id") long id) {
		List<Patient> patients=new ArrayList<>();
		List<PatientRelation> patientRelations=patientService.getDoctorPatients(id);
		log.info("patientRelations::"+patientRelations);
		Iterator<PatientRelation> it=patientRelations.iterator();
		while (it.hasNext()) {
			PatientRelation patientRelation = (PatientRelation) it.next();
			Patient patient=patientService.getPatientById(patientRelation.getPatientId());
			patients.add(patient);
		}	
		model.addAttribute("patients", patients);
		Doctor doctor=doctorService.findByDoctorId(id);
		model.addAttribute("doctor", doctor);
		model.addAttribute("id", id);
	    return "doctor/doctorhome"; 
	}
	@RequestMapping(value = { "/dnursevisiting/{id}"}, method = RequestMethod.GET)
	public String dnursePage(Model model,@PathVariable("id") long id) {
		List<PatientRelation> patientRelations=patientService.getDoctorPatients(id);
		
		List<PatientRelationBean> patientRelationBeans=patientService.getPatientRelationBeans(patientRelations);
		
		model.addAttribute("patientRelationBeans", patientRelationBeans);
		Doctor doctor=doctorService.findByDoctorId(id);
		model.addAttribute("doctor", doctor);
		model.addAttribute("id", id);
	    return "doctor/dnursevisiting";
	}
	/*@RequestMapping(value = { "/dgetinformationdoctor/{id}"}, method = RequestMethod.GET)
	public String dgetinformDoc(Model model,@PathVariable("id") long id) {		
		List<HealthRecord>  healthRecords= healthRecordService.getDHealthRecords(id);
		List<GetDocInfoBean> getDocInfoBeans=healthRecordService.getDocInfoBeans(healthRecords); 
		System.out.println("getDocInfoBeans::"+getDocInfoBeans);
		model.addAttribute("getDocInfoBeans", getDocInfoBeans);
		Doctor doctor=doctorService.findByDoctorId(id);
		model.addAttribute("doctor", doctor);
		model.addAttribute("id", id);
	    return "doctor/dgetinfofromdoctor";
	}*/
	@RequestMapping(value = { "/doctorcontacts/{id}"}, method = RequestMethod.GET)
	public String doctorcontact(Model model,@PathVariable("id") long id) {
		List<DoctorContact> doctorContacts=doctorContactService.getDDoctorContacts(id);		
		model.addAttribute("doctorContacts", doctorContacts);
		Doctor doctor=doctorService.findByDoctorId(id);
		model.addAttribute("doctor", doctor);
		model.addAttribute("id", id);
	    return "doctor/viewcontactdoctor";
	}
	@RequestMapping(value = { "/contactdoctoredit/{id}"}, method = RequestMethod.GET)
	public String admincontactedit(Model model,@PathVariable("id") long id,@RequestParam("caid") long caid) {
		DoctorContact doctorContact=doctorContactService.getDoctorContact(caid)	;			
		model.addAttribute("doctorContact", doctorContact);
		Doctor doctor=doctorService.findByDoctorId(id);
		model.addAttribute("doctor", doctor);
		model.addAttribute("id", id);
	    return "doctor/contactdoctor";
	}	
	@RequestMapping(value = { "/contactdoctor/{id}/{adid}"}, method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String contactAdmin(Model model, ContactDoctor contactDoctor,@PathVariable("id") long id,@PathVariable("adid") String adid) {
		System.out.println(contactDoctor);
		DoctorContact doctorContact=doctorContactService.getDoctorContact(Long.parseLong(adid));
		doctorContact.setAnswer(contactDoctor.getAnswer());
		doctorContactService.save(doctorContact);
		List<DoctorContact> doctorContacts=doctorContactService.getDDoctorContacts(id);		
		model.addAttribute("doctorContacts", doctorContacts);
		Doctor doctor=doctorService.findByDoctorId(id);
		model.addAttribute("doctor", doctor);
		model.addAttribute("adid", adid);
		
		model.addAttribute("id", id);
		MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(doctorContact.getPatientMailId());
            helper.setText(doctorContact.getAnswer());
            helper.setSubject(doctorContact.getQuery());
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error while sending mail ..";
        }
        //sender.send(message);
        		
	    return "doctor/viewcontactdoctor";
	}

}
