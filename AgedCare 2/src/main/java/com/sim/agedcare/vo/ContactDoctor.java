package com.sim.agedcare.vo;

import java.io.Serializable;

public class ContactDoctor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String patientMailId="";
	private String query="";
	private String answer="";
	private long patientId;
	private long doctorId;
	private long doctorContactId;
	private String patientName="";
	private String doctorName="";
	public String getPatientMailId() {
		return patientMailId;
	}
	public void setPatientMailId(String patientMailId) {
		this.patientMailId = patientMailId;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	public long getDoctorContactId() {
		return doctorContactId;
	}
	public void setDoctorContactId(long doctorContactId) {
		this.doctorContactId = doctorContactId;
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
	@Override
	public String toString() {
		return "ContactDoctor [patientMailId=" + patientMailId + ", query=" + query + ", answer=" + answer
				+ ", patientId=" + patientId + ", doctorId=" + doctorId + ", doctorContactId=" + doctorContactId
				+ ", patientName=" + patientName + ", doctorName=" + doctorName + "]";
	}
	
	
	

	
}
