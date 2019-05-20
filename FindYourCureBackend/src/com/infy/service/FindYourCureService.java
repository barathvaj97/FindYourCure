package com.infy.service;

import java.util.List;

import com.infy.model.Appointment;
import com.infy.model.Doctor;
import com.infy.model.Patient;

public interface FindYourCureService {
	
	public Patient addPatient(Patient patient) throws Exception;
	public Doctor addDoctor(Doctor doctor) throws Exception;
	public Patient loginPatient(Patient patient) throws Exception;
	public Doctor loginDoctor(Doctor doctor) throws Exception;
	public Patient updatePatient(Patient patient) throws Exception;
	public Doctor updateDoctor(Doctor doctor) throws Exception;
	public Appointment scheduleAppointment(Appointment appointment) throws Exception;
	public Patient displayPatient(Integer pid) throws Exception;
	public String getSpecialization(Appointment appointment) throws Exception;
	public List<Doctor> getDoctorList1(Appointment appointment) throws Exception;
	public List<Doctor> getDoctorList2(Appointment appointment ) throws Exception;
	public List<Patient>showAllPatients() throws Exception;
	public List<Doctor>showAllDoctors() throws Exception;
	public void deleteDoctor(Integer did) throws Exception; 
	public Doctor getDoc(Doctor doctor) throws Exception;
	public void deletePatient(Integer pid) throws Exception;
	List<Appointment> getAppointmentId(Integer did) throws Exception;
	Patient getPatientByAppId(Integer appid) throws Exception;
	public Appointment updateAppointment(Appointment appointment) throws Exception;
}
