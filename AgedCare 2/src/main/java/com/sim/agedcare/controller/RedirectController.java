package com.sim.agedcare.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sim.agedcare.entity.Doctor;
import com.sim.agedcare.entity.HealthRecord;
import com.sim.agedcare.entity.Patient;
import com.sim.agedcare.entity.PatientRelation;
import com.sim.agedcare.entity.User;
import com.sim.agedcare.service.DoctorService;
import com.sim.agedcare.service.HealthRecordService;
import com.sim.agedcare.service.LoginService;
import com.sim.agedcare.service.PatientService;
import com.sim.agedcare.vo.GetDocInfoBean;
import com.sim.agedcare.vo.LoginBean;
import com.sim.agedcare.vo.PatientLoginBean;


@Controller
@ComponentScan(basePackages="com.sim.agedcare")
public class RedirectController {
	private static final Logger logger = LoggerFactory.getLogger(RedirectController.class);

	@Autowired
	PatientService patientService;
	
	@Autowired
	HealthRecordService healthRecordService;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	DoctorService doctorService;
	
	@Value("${user.username}")
	public  String username;	
	
	@Value("${user.password}")
	public  String password;
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String loginPage(Model model) {
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		loginService.save(user);
		System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
	    return "login";
	}
	@RequestMapping(value = { "/alogin"}, method = RequestMethod.GET)
	public String aLoginPage(Model model) {
		List<Patient> patients=patientService.getPatients();		
		model.addAttribute("patients", patients);
	    return "admin/adminlogin"; 
	}	
	@RequestMapping(value = { "/adminlogin"}, method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String adminLoginPage(Model model,LoginBean loginBean) {
		System.out.println(loginBean);
		String redirect="";
		User user=loginService.getUser(loginBean);
		if(user!=null) {
			List<Patient> patients=patientService.getPatients();		
			model.addAttribute("patients", patients);
			redirect="admin/adminhome";
		}else {
			model.addAttribute("msg","Invalid Username and Password" );
			redirect="admin/adminlogin";
		}
		logger.info(""+loginBean+"   "+user);
	    return redirect;
	}	
	@RequestMapping(value = { "/plogin"}, method = RequestMethod.POST)
	public String patientLoginPage(Model model,PatientLoginBean patientLoginBean) {
		String redirect="";
		Patient patient=loginService.getPatient(patientLoginBean);
		LoginBean loginBean=new LoginBean();
		loginBean.setUsername(patientLoginBean.getPatientName());
		loginBean.setPassword(patientLoginBean.getPatientPassword());
		User user=loginService.userFind(loginBean);
		logger.info(patient+"|patient::"+patientLoginBean+"   "+user);
		if(user!=null && user.getUserType().equalsIgnoreCase("P")) {
			System.out.println(patient);
			//Patient patient=patientService.getPatientById(patient.getPatientId());
			long id=patient.getPatientId();
			List<HealthRecord>  healthRecords= healthRecordService.getHealthRecords(id);
			List<GetDocInfoBean> getDocInfoBeans=healthRecordService.getDocInfoBeans(healthRecords); 
			System.out.println("getDocInfoBeans::"+getDocInfoBeans);
			model.addAttribute("getDocInfoBeans", getDocInfoBeans);	
			model.addAttribute("patient", patient);
			model.addAttribute("id", patient.getPatientId());
			redirect="patient/patienthome";
		}
		else if(user!=null && user.getUserType().equalsIgnoreCase("D")) {
			Doctor doctor=doctorService.getDoctor(user.getUsername(), user.getPassword());
			List<Patient> patients=new ArrayList<>();
			List<PatientRelation> patientRelations=patientService.getDoctorPatients(doctor.getDoctorId());
			Iterator<PatientRelation> it=patientRelations.iterator();
			while (it.hasNext()) {
				PatientRelation patientRelation = (PatientRelation) it.next();
				patient=patientService.getPatientById(patientRelation.getPatientId());
				patients.add(patient);
			}	
			model.addAttribute("patients", patients);
			model.addAttribute("id", doctor.getDoctorId());
			model.addAttribute("doctor", doctor);
			redirect="doctor/doctorhome";
		}
		else {
			model.addAttribute("msg","Invalid Username and Password" );
			redirect="login";
			System.out.println("Invalid Username and Password "+patientLoginBean);
		}
		
	    return redirect;
	}
	@RequestMapping(value = { "/logout"}, method = RequestMethod.GET)
	public String logout(Model model) {		
	    return "login";
	}
	@RequestMapping(value = { "/healthrecord/addhealthrecord"}, method = RequestMethod.GET)
	public String addHealthRecord(Model model) {			
	    return "addhealthrecord";
	}
	@RequestMapping(value = { "/register"}, method = RequestMethod.GET)
	public String register(Model model) {			
	    return "register";
	}
		
}
