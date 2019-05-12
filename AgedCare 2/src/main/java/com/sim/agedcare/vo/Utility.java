package com.sim.agedcare.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sim.agedcare.entity.PatientRelation;

public class Utility {
	
	public static PatientRelationBean convertPRtoPRB(PatientRelation patientRelation) {		
		PatientRelationBean patientRelationBean=new PatientRelationBean();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");  
			Date d=patientRelation.getNurseVisitingDate();			
			patientRelationBean.setNurseVisitingDate(formatter.format(d));
			patientRelationBean.setReason(patientRelation.getReason());
			
			
			
		} catch (Exception e) {
			
		}
		return patientRelationBean;
	}

}
