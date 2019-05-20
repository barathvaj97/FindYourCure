package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="Doctor")
@GenericGenerator(name = "incr", strategy = "increment")	
public class DoctorEntity {

	@Id
	@GeneratedValue(generator = "incr")
	private Integer did;
	private String dname;
	private Integer yrsofexp;
	private String visithours;
	private String visithoursend;
	private Integer fee;
	private String spc;
	private String password;
	private String email;
	
	public String getVisithoursend() {
		return this.visithoursend;
	}
	public void setVisithoursend(String visithoursend) {
		this.visithoursend = visithoursend;
	}
	
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Integer getYrsofexp() {
		return yrsofexp;
	}
	public void setYrsofexp(Integer yrsofexp) {
		this.yrsofexp = yrsofexp;
	}
	public String getVisithours() {
		return visithours;
	}
	public void setVisithours(String visithours) {
		this.visithours = visithours;
	}
	public Integer getFee() {
		return fee;
	}
	public void setFee(Integer fee) {
		this.fee = fee;
	}
	public String getSpc() {
		return spc;
	}
	public void setSpc(String spc) {
		this.spc = spc;
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
	


	
}
