package com.paf.HospitalManagement.HelthCare.Bean;

public class HospitalBean {

	int hospital_id;
	String hospitalName;
	String email;	 
	int phoneNo;
	String city;
	String address;
	
	public HospitalBean() {
		 
	}

	public HospitalBean(int hospital_id, String hospitalName, String email, int phoneNo, String city, String address) {
		super();
		this.hospital_id = hospital_id;
		this.hospitalName = hospitalName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.city = city;
		this.address = address;
	}

	public int getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	 
	
}