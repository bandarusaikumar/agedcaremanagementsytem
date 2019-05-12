package com.sim.agedcare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOCTOR_ID")
    private Long doctorId;
    @Column(name = "DOCTOR_NAME")
    private String doctorName;
    @Column(name = "INFO")
    private String info;
    @Column(name = "DOCTOR_PASSWORD")
    private String doctorPassword;
    @Column(name = "DOCTOR_ADDRESS")
    private String doctorAddress;
    @Column(name = "DOCTOR_EMAIL")
    private String doctorEmail;
    @Column(name = "DOCTOR_AGE")
    private String doctorAge;
    @Column(name = "DOCTOR_CONTACTNUMBER")
    private String doctorContactnumber;
    
  
    public String getDoctorPassword() {
		return doctorPassword;
	}
	public void setDoctorPassword(String doctorPassword) {
		this.doctorPassword = doctorPassword;
	}
	public String getDoctorAddress() {
		return doctorAddress;
	}
	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}
	public String getDoctorEmail() {
		return doctorEmail;
	}
	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}
	public String getDoctorAge() {
		return doctorAge;
	}
	public void setDoctorAge(String doctorAge) {
		this.doctorAge = doctorAge;
	}
	public String getDoctorContactnumber() {
		return doctorContactnumber;
	}
	public void setDoctorContactnumber(String doctorContactnumber) {
		this.doctorContactnumber = doctorContactnumber;
	}
	public Long getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
