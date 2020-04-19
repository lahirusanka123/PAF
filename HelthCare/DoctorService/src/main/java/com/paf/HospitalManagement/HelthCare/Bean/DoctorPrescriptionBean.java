package com.paf.HospitalManagement.HelthCare.Bean;

public class DoctorPrescriptionBean {
	
	int prescription_id;
	String patient_name;
	String doctor_name;
	String medicine;
	String description;
	
	public DoctorPrescriptionBean () {
		
	}
	
	//Paramiterize Constructor
	public DoctorPrescriptionBean (int prescription_id,String patient_name ,String doctor_name, String medicine, String description) {
		
		super();
		this.prescription_id = prescription_id;
		this.patient_name =patient_name;
		this.doctor_name = doctor_name;
		this.medicine = medicine;
		this.description = description;
	}

	//Getters and Setters Method
	public int getPrescription_id() {
		return prescription_id;
	}

	public void setPrescription_id(int prescription_id) {
		this.prescription_id = prescription_id;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
	