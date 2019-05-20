package com.infy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dao.FindYourCureDAO ;
import com.infy.model.Appointment;
import com.infy.model.Doctor;
import com.infy.model.Patient;

@Service("userService")
@Transactional(readOnly = true)
public class FindYourCureServiceImpl implements FindYourCureService {

	
	@Autowired
	private FindYourCureDAO dao;

	
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public Patient addPatient(Patient patient) throws Exception {
		
		Patient p=new Patient();
		 p=dao.addPatient(patient);
			return p;	
	}


	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public Doctor addDoctor(Doctor doctor) throws Exception {
		
		Doctor d=new Doctor();
		 d=dao.addDoctor(doctor);
			return d;
	}


	@Override
	@Transactional(readOnly = false)
	public Patient loginPatient(Patient patient) throws Exception {
		
		Patient patient1=dao.loginPatient(patient);
		return patient1;
		
	}
	
	@Override
	@Transactional(readOnly = false)
	public Doctor loginDoctor(Doctor doctor) throws Exception {
		
		Doctor doctor1=dao.loginDoctor(doctor);
		return doctor1;
		
	}


	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Patient updatePatient(Patient patient) throws Exception {


		Patient patient1 = dao.updatePatient(patient);
		
		if(patient1 == null) {
			throw new Exception("Service.INVALID_PATIENT_ID");
		}
		
		return patient1;
		
	}


	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Doctor updateDoctor(Doctor doctor) throws Exception {


		Doctor doctor1 = dao.updateDoctor(doctor);
		
		if(doctor1 == null) {
			throw new Exception("Service.INVALID_DOCTOR_ID");
		}
		
		return doctor1;
		
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Appointment scheduleAppointment(Appointment appointment)
			throws Exception {
		
		Appointment app=new Appointment();
		System.out.println("in service");
		app=dao.scheduleAppointment(appointment);
		System.out.println(app.getAppid() + "in after service");
			return app;
		
	}


	@Override
	public Patient displayPatient(Integer pid) throws Exception {
		
		Patient patient = dao.displayPatient(pid);
		
		if(patient == null) {
			throw new Exception("Service.INVALID_PATIENT_ID");
		}
		
		return patient;

}
	
	@Override
	public String getSpecialization(Appointment appointment) throws Exception {
		
		String d = dao.getSpecialization(appointment);
		
		if(d.equals(null)) {
			throw new Exception("Service.INVALID_SPECIALIZATION");
		}
		
		return d;

}


	@Override
	public List<Doctor> getDoctorList1(Appointment appointment) throws Exception {
		
		List<Doctor> doclist1=dao.getDoctorList1(appointment);
		
		if(doclist1.equals(null)) {
			throw new Exception("Service.INVALID_SPECIALIZATION");
		}
		
		return doclist1;
	}


	@Override
	public List<Doctor> getDoctorList2(Appointment appointment)
			throws Exception {
		
		List<Doctor> doclist2=dao.getDoctorList2(appointment);
		
		if(doclist2.equals(null)) {
			throw new Exception("Service.INVALID_SPECIALIZATION");
		}
		
		return doclist2;
	}

	@Override
	public List<Patient> showAllPatients() throws Exception {
		List<Patient> listOfPatients= dao.showAllPatients();
		if(listOfPatients.size()<=0){
			throw new Exception("No Patients Available");
		}
		return listOfPatients;
	}

	@Override
	public List<Doctor> showAllDoctors() throws Exception {
		List<Doctor> listOfDoctors= dao.showAllDoctors();
		if(listOfDoctors.size()<=0){
			throw new Exception("No Doctors Available");
		}
		return listOfDoctors;
	}
	
	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public void deleteDoctor(Integer did) throws Exception {
		{	
			
			


			Doctor dt = new Doctor();
			dt.setDid(did);
	
		
		Doctor d=dao.getDoc(dt);
		
		if ( d.getDid()!= null)
			dao.deletDoctor(did);
		else
			throw new Exception("Service.INVALID_DOCTOR_ID");
		
		}
	
	
		
	
	}


	@Override
	public Doctor getDoc(Doctor doctor) throws Exception {
		
		
		Doctor doctor1=dao.getDoc(doctor);
		return doctor1;
		
		
		
		
	}


	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public void deletePatient(Integer pid) throws Exception {

		Patient pt = new Patient();
		pt = dao.displayPatient(pid);
		
		if ( pt.getPid()!= null)
			dao.deletePatient(pid);
		else
			throw new Exception("Service.INVALID_DOCTOR_ID");
		
		}

	
	@Override
	public List<Appointment> getAppointmentId(Integer did) throws Exception {
		// TODO Auto-generated method stub
		
		List<Appointment> ap = dao.getAppointmentId(did);
		
		return ap;
	}


	@Override
	public Patient getPatientByAppId(Integer appid) throws Exception {
		// TODO Auto-generated method stub
		Patient p = dao.getPatientByAppId(appid);
		return p;
	}


	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public Appointment updateAppointment(Appointment appointment) throws Exception {
		// TODO Auto-generated method stub
		Appointment ap1 = dao.updateAppointment(appointment);
		
		if(ap1 == null) {
			throw new Exception("Service.INVALID_DOCTOR_ID");
		}
		
		return ap1;
		
		
	}


		
	}




	
		


