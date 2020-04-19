
package com.paf.HospitalManagement.HelthCare.Bean;

public class DoctorFeedbackBean {
	
		int feedbackId;
		String userName;
		String date;
		String msg;
		
		public DoctorFeedbackBean() {
			
		}
		
		//Paramiterize Constructor
		public DoctorFeedbackBean(int feedbackId, String userName, String date, String msg) {
			super();
			this.feedbackId = feedbackId;
			this.userName = userName;
			this.date = date;
			this.msg = msg;
		}
		
		//Create Getters and Setters
		public int getFeedbackId() {
			return feedbackId;
		}

		public void setFeedbackId(int feedbackId) {
			this.feedbackId = feedbackId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}
		

}
