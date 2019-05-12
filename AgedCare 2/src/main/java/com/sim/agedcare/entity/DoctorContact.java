package com.sim.agedcare.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DoctorContact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long doctorContactId;
	private long patientId;
	private long doctorId;
	private String patientMailId="";
	private String query="";
	private String answer="";
	private String patientName="";
	private String doctorName="";
	public long getDoctorContactId() {
		return doctorContactId;
	}
	public void setDoctorContactId(long doctorContactId) {
		this.doctorContactId = doctorContactId;
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
		return "DoctorContact [doctorContactId=" + doctorContactId + ", patientId=" + patientId + ", doctorId="
				+ doctorId + ", patientMailId=" + patientMailId + ", query=" + query + ", answer=" + answer
				+ ", patientName=" + patientName + ", doctorName=" + doctorName + "]";
	}
	
	
	
	
	
}
