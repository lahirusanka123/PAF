package com.paf.HospitalManagement.HelthCare.Bean;

public class PaymentBean {
	
	int payment_id;
	int hospital_id;
	int patient_id;
	int appointment_id;
	String type;
	float amount;
	String date;
	
	
	public PaymentBean() {
		 
	}
	
	public PaymentBean(int payment_id, int hospital_id, int patient_id, int appointment_id, String type, float amount,
			String date) {
		super();
		this.payment_id = payment_id;
		this.hospital_id = hospital_id;
		this.patient_id = patient_id;
		this.appointment_id = appointment_id;
		this.type = type;
		this.amount = amount;
		this.date = date;
	}
	
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public int getHospital_id() {
		return hospital_id;
	}
	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public int getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	  

}
