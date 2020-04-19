package com.paf.HospitalManagement.HelthCare.Bean;

public class DoctorAppointmentBean {
	
	int appoinement_id;
	int patient_no;
	String patient_name;
	String time;
	String date;
	String status;
	
	public DoctorAppointmentBean(){
		
	}
	
	//Paramiterize Constructor
	public DoctorAppointmentBean(int appoinement_id, int patient_no, String patient_name, String time, String date,
			String status) {
		super();
		this.appoinement_id = appoinement_id;
		this.patient_no = patient_no;
		this.patient_name = patient_name;
		this.time = time;
		this.date = date;
		this.status = status;
	}


	//Getters and Setters Method
	public int getAppoinement_id() {
		return appoinement_id;
	}

	public void setAppoinement_id(int appoinement_id) {
		this.appoinement_id = appoinement_id;
	}

	public int getPatient_no() {
		return patient_no;
	}

	public void setPatient_no(int patient_no) {
		this.patient_no = patient_no;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
	
}
