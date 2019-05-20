package com.infy.model;





public class Patient {

	private Integer pid;
	private String pname;
	private String gender;
	private Integer age;
	private Integer annualinc;
	private String histofill;
	private String histofmeds;
	private String message;
	private String password;
	private String email;
	private Appointment app;
	

	
	public Appointment getApp() {
		return app;
	}
	public void setApp(Appointment a) {
		this.app = a;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getAnnualinc() {
		return annualinc;
	}
	public void setAnnualinc(Integer annualinc) {
		this.annualinc = annualinc;
	}
	public String getHistofill() {
		return histofill;
	}
	public void setHistofill(String histofill) {
		this.histofill = histofill;
	}
	public String getHistofmeds() {
		return histofmeds;
	}
	public void setHistofmeds(String histofmeds) {
		this.histofmeds = histofmeds;
	}
	
	
	
	
	 
}
