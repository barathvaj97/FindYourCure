package com.infy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.entity.AppointmentEntity;
import com.infy.entity.DoctorEntity;
import com.infy.entity.PatientEntity;
import com.infy.entity.SymptomSpcEntity;
import com.infy.model.Appointment;
import com.infy.model.Doctor;
import com.infy.model.Patient;



@Repository("patientdao")
public class FindYourCureDAOImpl implements FindYourCureDAO {

	@Autowired
	SessionFactory sessionFactory;


	@Override
	public Patient addPatient(Patient patient) throws Exception 
	{  
		
		Session session=null;
		 session =sessionFactory.getCurrentSession();
		PatientEntity pe=new PatientEntity();
		pe.setAge(patient.getAge());
		pe.setAnnualinc(patient.getAnnualinc());
		pe.setEmail(patient.getEmail());
		pe.setGender(patient.getGender());
		pe.setHistofmeds(patient.getHistofmeds());
		pe.setHistofill(patient.getHistofill());
		pe.setPassword(patient.getPassword());
		pe.setPid(patient.getPid());
		pe.setPname(patient.getPname());
		if (patient.getApp() != null) {
			AppointmentEntity ae = new AppointmentEntity();
			Appointment app2 = patient.getApp();
			ae.setDateofapp(app2.getDateofapp());
			ae.setDays(app2.getDays());
			ae.setSymptom1(app2.getSymptom1());
			if(app2.getSymptom2()!=null)
				ae.setSymptom2(app2.getSymptom2());
			if(app2.getSymptom3()!=null)
				ae.setSymptom3(app2.getSymptom3());
			pe.setApp(ae);
		}
		
		session.persist(pe);
		patient.setPid(pe.getPid());
		return patient;
	}


	@Override
	public Doctor addDoctor(Doctor doctor) throws Exception {
		
		Session session=null;
		session =sessionFactory.getCurrentSession();
		DoctorEntity de=new DoctorEntity();
		de.setDid(doctor.getDid());
		de.setDname(doctor.getDname());
		de.setEmail(doctor.getEmail());
		de.setFee(doctor.getFee());
		de.setPassword(doctor.getPassword());
		de.setSpc(doctor.getSpc());
		de.setVisithours(doctor.getVisithours());
		de.setVisithoursend(doctor.getVisithoursend());
		de.setYrsofexp(doctor.getYrsofexp());
		session.persist(de);
		doctor.setDid(de.getDid());
		return doctor;	
		
	}


	@Override
	public Patient loginPatient(Patient patient) throws Exception {
		
		Session session=null;
		session=sessionFactory.getCurrentSession();
		PatientEntity patientEntity=session.get(PatientEntity.class, patient.getPid());
		if(patientEntity!=null && patient.getPassword().equals(patientEntity.getPassword()))
		{
			patient.setMessage("Login Sucessfull!");
			patient.setPid(patientEntity.getPid());
			patient.setPname(patientEntity.getPname());
			patient.setEmail(patientEntity.getEmail());
			patient.setAge(patientEntity.getAge());
			patient.setGender(patientEntity.getGender());
			patient.setAnnualinc(patientEntity.getAnnualinc());
			patient.setHistofill(patientEntity.getHistofill());
			patient.setHistofmeds(patientEntity.getHistofmeds());
			patient.setPassword(patientEntity.getPassword());
			
			Appointment a=new Appointment();
			if(patientEntity.getApp()!=null)
			{a.setSymptom1(patientEntity.getApp().getSymptom1());
			if(patientEntity.getApp().getSymptom2()!=null)
				a.setSymptom2(patientEntity.getApp().getSymptom2());
			if(patientEntity.getApp().getSymptom3()!=null)
				a.setSymptom3(patientEntity.getApp().getSymptom3());
			a.setDays(patientEntity.getApp().getDays());
			a.setDateofapp(patientEntity.getApp().getDateofapp());
			a.setAppid(patientEntity.getApp().getAppid());
			a.setDoctorid(patientEntity.getApp().getDoctorid());
			a.setStatus(patientEntity.getApp().getStatus());
			}
			patient.setApp(a);
		}
		else{
			patient.setPid(-1);
		}
			return patient;
		
	
	}


	@Override
	public Doctor loginDoctor(Doctor doctor) throws Exception {
		
		Session session=null;
		session=sessionFactory.getCurrentSession();
		DoctorEntity doctorEntity=session.get(DoctorEntity.class, doctor.getDid());
		if(doctorEntity!=null && doctor.getPassword().equals(doctorEntity.getPassword()))
		{
			doctor.setMessage("Login Sucessfull!");
			doctor.setDid(doctorEntity.getDid());
			doctor.setDname(doctorEntity.getDname());
			doctor.setYrsofexp(doctorEntity.getYrsofexp());
			doctor.setVisithours(doctorEntity.getVisithours());
			doctor.setVisithoursend(doctorEntity.getVisithoursend());
		
			doctor.setFee(doctorEntity.getFee());
			doctor.setSpc(doctorEntity.getSpc());
			doctor.setEmail(doctorEntity.getEmail());
			doctor.setPassword(doctorEntity.getPassword());
			
		}
		else{
			doctor.setDid(-1);
		}
			return doctor;
		
	}


	@Override
	public Patient updatePatient(Patient patient) throws Exception {


		Session session = sessionFactory.getCurrentSession();
		PatientEntity patientEntity = session.get(PatientEntity.class, patient.getPid());
		
		if(	patientEntity !=null) {
			if(patient.getPname()!=null)           //Only those fields will get updated which are given
			patientEntity.setPname(patient.getPname());
			if(patient.getEmail()!=null)
			patientEntity.setEmail(patient.getEmail());
			if(patient.getPassword()!=null)
			patientEntity.setPassword(patient.getPassword());
			if(patient.getAge()!=null)
			patientEntity.setAge(patient.getAge());
			if(patient.getGender()!=null)
			patientEntity.setGender(patient.getGender());
			if(patient.getAnnualinc()!=null)
			patientEntity.setAnnualinc(patient.getAnnualinc());
			if(patient.getHistofill()!=null)
			patientEntity.setHistofill(patient.getHistofill());
			if(patient.getHistofmeds()!=null)
			patientEntity.setHistofmeds(patient.getHistofmeds());
			if(patient.getApp()!=null)
            {AppointmentEntity pe = new AppointmentEntity();
            Appointment a=patient.getApp();
            pe.setAppid(a.getAppid());
            pe.setDateofapp(a.getDateofapp());
            pe.setDays(a.getDays());
            pe.setDoctorid(a.getDoctorid());
            pe.setSymptom1(a.getSymptom1());
            pe.setSymptom2(a.getSymptom2());
            pe.setStatus(a.getStatus());
            patientEntity.setApp(pe);     
            
            }

			
			
			
			return patient;
		}
		return null;
	
	}


	@Override
	public Doctor updateDoctor(Doctor doctor) throws Exception {


		Session session = sessionFactory.getCurrentSession();
		DoctorEntity doctorEntity = session.get(DoctorEntity.class, doctor.getDid());
		if(	doctorEntity !=null) {
			if(doctor.getDname()!=null)
			doctorEntity.setDname(doctor.getDname());
			if(doctor.getEmail()!=null)
			doctorEntity.setEmail(doctor.getEmail());
			if(doctor.getPassword()!=null)
			doctorEntity.setPassword(doctor.getPassword());
			if(doctor.getSpc()!=null)
			doctorEntity.setSpc(doctor.getSpc());
			if(doctor.getYrsofexp()!=null)
			doctorEntity.setYrsofexp(doctor.getYrsofexp());
			if(doctor.getVisithours()!=null)
			doctorEntity.setVisithours(doctor.getVisithours());
			if(doctor.getVisithoursend()!=null)
			doctorEntity.setVisithoursend(doctor.getVisithoursend());
			if(doctor.getFee()!=null)
			doctorEntity.setFee(doctor.getFee());
		
			
			return doctor;
		}
		return null;
	}


	@Override
	public Appointment scheduleAppointment(Appointment appointment)
			throws Exception {
		 
		Session session=sessionFactory.getCurrentSession();
		
		AppointmentEntity app=new AppointmentEntity();
		app.setAppid(appointment.getAppid());
		app.setSymptom1(appointment.getSymptom1());
		app.setSymptom2(appointment.getSymptom2());
		app.setSymptom3(appointment.getSymptom3());
		app.setDays(appointment.getDays());
		app.setDateofapp(appointment.getDateofapp());
		app.setStatus("Pending");
		System.out.println("Pending");

		session.persist(app);
		
		
		appointment.setAppid(app.getAppid());
		return appointment;
		
	}


	@Override
	public Patient displayPatient(Integer pid) throws Exception {
		
		Session session = sessionFactory.getCurrentSession();
		PatientEntity pe = session.get(PatientEntity.class, pid );
		if(	pe !=null) {
			Patient patient = new Patient();
			
			Appointment a=new Appointment();
			if(pe.getApp()!=null)
			{a.setSymptom1(pe.getApp().getSymptom1());
			if(pe.getApp().getSymptom2()!=null)
				a.setSymptom2(pe.getApp().getSymptom2());
			if(pe.getApp().getSymptom3()!=null)
				a.setSymptom3(pe.getApp().getSymptom3());
			a.setDays(pe.getApp().getDays());
			a.setDateofapp(pe.getApp().getDateofapp());
			a.setAppid(pe.getApp().getAppid());
			a.setDoctorid(pe.getApp().getDoctorid());
			a.setStatus(pe.getApp().getStatus());
			}
			patient.setPid(pe.getPid());
			patient.setPname(pe.getPname());
			patient.setEmail(pe.getEmail());
			patient.setAge(pe.getAge());
			patient.setGender(pe.getGender());
			patient.setAnnualinc(pe.getAnnualinc());
			patient.setHistofill(pe.getHistofill());
			patient.setPassword(pe.getPassword());
			patient.setHistofmeds(pe.getHistofmeds());
	
			patient.setApp(a);
			
			
			return patient;
		}
		
//		System.out.println("asdvgukguo");
		return null;
	}


	@Override
	public String getSpecialization(Appointment appointment) throws Exception {
		
		String one=appointment.getSymptom1();
		String two=appointment.getSymptom2();
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<SymptomSpcEntity> criteriaQuery = criteriaBuilder.createQuery(SymptomSpcEntity.class);
		Root<SymptomSpcEntity> root = criteriaQuery.from(SymptomSpcEntity.class);
		if(two==null)
			criteriaQuery.where(criteriaBuilder.or(criteriaBuilder.equal(root.get("symptom1"),one.toLowerCase()),criteriaBuilder.equal(root.get("symptom2"),one.toLowerCase())));
			if(two!=null)          
	            criteriaQuery.where(criteriaBuilder.or(criteriaBuilder.and(criteriaBuilder.equal(root.get("symptom1"),one.toLowerCase()),criteriaBuilder.equal(root.get("symptom2"),two.toLowerCase())),criteriaBuilder.and(criteriaBuilder.equal(root.get("symptom2"),one.toLowerCase()),criteriaBuilder.equal(root.get("symptom1"),two.toLowerCase()))));

		Query<SymptomSpcEntity> query = session.createQuery(criteriaQuery);

		SymptomSpcEntity k = query.getSingleResult();
	
		String spc=k.getSpecialization().toLowerCase();
	
		
		return spc;
	}


	@Override
	public List<Doctor> getDoctorList1(Appointment appointment) throws Exception {

		String specialization=getSpecialization(appointment);

		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<DoctorEntity> criteriaQuery = criteriaBuilder.createQuery(DoctorEntity.class);
		Root<DoctorEntity> root = criteriaQuery.from(DoctorEntity.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("spc"),specialization));
		Query<DoctorEntity> query = session.createQuery(criteriaQuery);
		List<DoctorEntity> ld= query.getResultList();

		List<Doctor> ld2=new ArrayList<>();
		for(DoctorEntity ds : ld){
	
			Doctor d2=new Doctor();
			d2.setDid(ds.getDid());
			d2.setDname(ds.getDname());
			d2.setEmail(ds.getEmail());
			d2.setFee(ds.getFee());
			d2.setPassword(ds.getPassword());
			d2.setSpc(ds.getSpc());
			d2.setVisithours(ds.getVisithours());
			d2.setVisithoursend(ds.getVisithoursend());
			d2.setYrsofexp(ds.getYrsofexp());
		ld2.add(d2);
		System.out.println(d2);
		}
		
		
		return ld2;
	}


	@Override
	public List<Doctor> getDoctorList2(Appointment appointment )
			throws Exception {
		Integer x=appointment.getTemp();

		Session session = sessionFactory.getCurrentSession();
		PatientEntity pe = session.get(PatientEntity.class,x );
		Integer income=pe.getAnnualinc()/2;
		System.out.println("Income:"+income);
		
		List<Doctor> ld3=new ArrayList<>();
		ld3=getDoctorList1(appointment);
	
		List<Doctor> ld4=new ArrayList<>();
		for(Doctor ds : ld3){
			System.out.println("ds.getFee:"+ds.getFee());
			if(ds.getFee()<income)
				{ld4.add(ds);
				System.out.println("Inside IF");
				System.out.println("ds:"+ds);
				}
		}
		
		return ld4;
	}

	@Override
	public List<Patient> showAllPatients() throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Patient> allPatients = null;
		
			
			Query qry = session.createQuery("select patient from PatientEntity patient");
			
			@SuppressWarnings("unchecked")
			List<PatientEntity> allPatientEntities = qry.list();
			
			allPatients = new ArrayList<Patient>();
			
			for (PatientEntity pe : allPatientEntities) {
				
				Patient p = new Patient();
				p.setPid(pe.getPid());
				p.setPname(pe.getPname());
				p.setEmail(pe.getEmail());
				p.setAge(pe.getAge());
				p.setGender(pe.getGender());
				p.setAnnualinc(pe.getAnnualinc());
				p.setHistofill(pe.getHistofill());
				p.setPassword(pe.getPassword());
				p.setHistofmeds(pe.getHistofmeds());

				AppointmentEntity ae= pe.getApp();
			if(ae !=null)
				{Appointment ap = new Appointment();
				
				ap.setAppid(ae.getAppid());
				ap.setDateofapp(ae.getDateofapp());
				ap.setDays(ae.getDays());
				ap.setDoctorid(ae.getDoctorid());
				ap.setSymptom1(ae.getSymptom1());
				ap.setSymptom2(ae.getSymptom2());
				
				}
				allPatients.add(p);
				
			}
			
			return allPatients;
			
		
		
	}


	@Override
	public List<Doctor> showAllDoctors() throws Exception {
		// TODO Auto-generated method stub
				Session session = sessionFactory.getCurrentSession();
				List<Doctor> allDoctors = null;
				
					
					Query qry = session.createQuery("select doc from DoctorEntity doc");
					
					@SuppressWarnings("unchecked")
					List<DoctorEntity> allDoctorEntities = qry.list();
					
					allDoctors = new ArrayList<Doctor>();
					
					for (DoctorEntity de : allDoctorEntities) {
						
						Doctor d = new Doctor();
						d.setDid(de.getDid());
						d.setDname(de.getDname());
						d.setEmail(de.getEmail());
						d.setFee(de.getFee());
						d.setSpc(de.getSpc());
						d.setVisithours(de.getVisithours());
						d.setVisithoursend(de.getVisithoursend());
						d.setYrsofexp(de.getYrsofexp());
						
						allDoctors.add(d);
						
					}
					
					return allDoctors;
	}
	
	/////////////////////////////
	@Override
	public void deletDoctor(Integer did) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		System.out.println("session");
		DoctorEntity doctorEntity = session.get(DoctorEntity.class,did);
		System.out.println(doctorEntity.getDid()+" "+"sdas");
		session.delete(doctorEntity);
	
	
	}
	
	
	@Override
	public Doctor getDoc(Doctor doctor) throws Exception {
	
	
		Session session=null;
		session=sessionFactory.getCurrentSession();
		DoctorEntity doctorEntity=session.get(DoctorEntity.class, doctor.getDid());
		System.out.println(doctorEntity.getDid());
		
		
		doctor.setMessage("Login Successfull!");
		doctor.setDid(doctorEntity.getDid());
		doctor.setDname(doctorEntity.getDname());
		doctor.setYrsofexp(doctorEntity.getYrsofexp());
		doctor.setVisithours(doctorEntity.getVisithours());
		doctor.setVisithoursend(doctorEntity.getVisithoursend());
		doctor.setFee(doctorEntity.getFee());
		doctor.setSpc(doctorEntity.getSpc());
		doctor.setEmail(doctorEntity.getEmail());
		doctor.setPassword(doctorEntity.getPassword());
		
		
		return doctor;
	
	}
	
	
	@Override
	public void deletePatient(Integer pid) throws Exception {
	
		Session session = sessionFactory.getCurrentSession();
		System.out.println("session");
		PatientEntity patientEntity = session.get(PatientEntity.class, pid);
		System.out.println(patientEntity.getPid()+" "+"sdas");
		session.delete(patientEntity);
	
	
	}

	
	@Override
	public List<Appointment> getAppointmentId(Integer did)throws Exception {
		// TODO Auto-generated method stub
		List<Appointment> pa = new ArrayList<Appointment>();
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<AppointmentEntity> criteriaQuery = criteriaBuilder.createQuery(AppointmentEntity.class);
		Root<AppointmentEntity> root = criteriaQuery.from(AppointmentEntity.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("doctorid"),did));
		Query<AppointmentEntity> query = session.createQuery(criteriaQuery);
		List<AppointmentEntity> a= query.getResultList();
System.out.println("did"+" "+a.isEmpty());
System.out.println(a.size()+"size of a");

		for(AppointmentEntity ae:a){
			Appointment ap = new Appointment();
			ap.setAppid(ae.getAppid());
			ap.setDateofapp(ae.getDateofapp());
			ap.setDays(ae.getDays());
			ap.setDoctorid(ae.getDoctorid());
			ap.setSymptom1(ae.getSymptom1());
			ap.setSymptom2(ae.getSymptom2());
			ap.setStatus(ae.getStatus());
		pa.add(ap);
		}

		return pa;
	}


	@Override
	public Patient getPatientByAppId(Integer appid) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<PatientEntity> criteriaQuery = criteriaBuilder.createQuery(PatientEntity.class);
	
		Root<PatientEntity> root = criteriaQuery.from(PatientEntity.class);
		
		criteriaQuery.where(criteriaBuilder.equal(root.get("appEntity"),appid));
		Query<PatientEntity> query = session.createQuery(criteriaQuery);
		PatientEntity pe = query.getSingleResult();
		
		
		Patient p = new Patient();
		
		p.setPid(pe.getPid());
		p.setPname(pe.getPname());
		p.setEmail(pe.getEmail());
		p.setAge(pe.getAge());
		p.setGender(pe.getGender());
		p.setAnnualinc(pe.getAnnualinc());
		p.setHistofill(pe.getHistofill());
		p.setPassword(pe.getPassword());
		p.setHistofmeds(pe.getHistofmeds());
		
		
		AppointmentEntity ae= pe.getApp();
		Appointment ap = new Appointment();
		ap.setAppid(ae.getAppid());
		ap.setDateofapp(ae.getDateofapp());
		ap.setDays(ae.getDays());
		ap.setDoctorid(ae.getDoctorid());
		ap.setSymptom1(ae.getSymptom1());
		ap.setSymptom2(ae.getSymptom2());
		ap.setStatus(ae.getStatus());
		p.setApp(ap);

		return p;
	}


	@Override
	public Appointment updateAppointment(Appointment appointment) throws Exception {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		AppointmentEntity appointmentEntity = session.get(AppointmentEntity.class, appointment.getAppid());
		if(	appointmentEntity !=null) {
			
			appointmentEntity.setSymptom1(appointment.getSymptom1());
			appointmentEntity.setSymptom2(appointment.getSymptom2());
			appointmentEntity.setSymptom3(appointment.getSymptom3());
			appointmentEntity.setDays(appointment.getDays());
			appointmentEntity.setDoctorid(appointment.getDoctorid());
			appointmentEntity.setDateofapp(appointment.getDateofapp());
			appointmentEntity.setStatus(appointment.getStatus());
			
	}
return  appointment;

	}

	

	
}
