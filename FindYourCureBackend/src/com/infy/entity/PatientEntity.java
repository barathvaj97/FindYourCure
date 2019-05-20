	package com.infy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Patient")
@GenericGenerator(name = "incr", strategy = "increment")	
public class PatientEntity {

	@Id
	@GeneratedValue(generator = "incr")
	private Integer pid;
	private String pname;
	private String gender;
	private Integer age;
	private Integer annualinc;
	private String histofill;
	private String histofmeds;
	private String password;
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "appid", unique = true)
	private AppointmentEntity appEntity;
	
	
	
	public AppointmentEntity getApp() {
		return appEntity;
	}
	public void setApp(AppointmentEntity appEntity) {
		this.appEntity = appEntity;
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
