package com.infy.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="APPOINTMENT")
@GenericGenerator(name = "incr", strategy = "increment")
public class AppointmentEntity {
	
	@Id
	@GeneratedValue(generator = "incr")
	private Integer appid;
	private String symptom1;
	private String symptom2;
	private String symptom3;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private Integer doctorid;
	
	public Integer getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(Integer doctorid) {
		this.doctorid = doctorid;
	}
	public String getSymptom2() {
		return symptom2;
	}
	public void setSymptom2(String symptom2) {
		this.symptom2 = symptom2;
	}
	public String getSymptom3() {
		return symptom3;
	}
	public void setSymptom3(String symptom3) {
		this.symptom3 = symptom3;
	}
	private Integer days;
	@Temporal(TemporalType.DATE)
	private Date dateofapp;
	
	public Integer getAppid() {
		return appid;
	}
	public void setAppid(Integer appid) {
		this.appid = appid;
	}
	
	public String getSymptom1() {
		return symptom1;
	}
	public void setSymptom1(String symptom1) {
		this.symptom1 = symptom1;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public Date getDateofapp() {
		return dateofapp;
	}
	public void setDateofapp(Date dateofapp) {
		this.dateofapp = dateofapp;
	}
}
