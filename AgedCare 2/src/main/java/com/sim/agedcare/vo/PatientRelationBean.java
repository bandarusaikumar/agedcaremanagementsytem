package com.sim.agedcare.vo;

import java.io.Serializable;

public class PatientRelationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private long pat_relationId;
	private String patientName="";
	private String doctorName="";
	private String nuirseName="";
	 private String nurseVisitingDate;
	 private String reason="";
	 
	 
	public long getPat_relationId() {
		return pat_relationId;
	}
	public void setPat_relationId(long pat_relationId) {
		this.pat_relationId = pat_relationId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getNuirseName() {
		return nuirseName;
	}
	public void setNuirseName(String nuirseName) {
		this.nuirseName = nuirseName;
	}
	public String getNurseVisitingDate() {
		return nurseVisitingDate;
	}
	public void setNurseVisitingDate(String nurseVisitingDate) {
		this.nurseVisitingDate = nurseVisitingDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "PatientRelationBean [patientName=" + patientName + ", doctorName=" + doctorName + ", nuirseName="
				+ nuirseName + ", nurseVisitingDate=" + nurseVisitingDate + ", reason=" + reason + "]";
	}

	
}
