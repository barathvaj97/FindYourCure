package com.infy.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.model.Appointment;
import com.infy.model.Doctor;
import com.infy.model.Patient;
import com.infy.service.FindYourCureService;
import com.infy.service.FindYourCureServiceImpl;
import com.infy.utility.ContextFactory;

@RestController
@CrossOrigin
@RequestMapping("FindYourCureAPI")
public class FindYourCureAPI {
	
	private FindYourCureService service;
	private Environment environment;
	
	@RequestMapping(method=RequestMethod.POST, value="addPatient")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient)
	{
		environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<Patient> responseEntity=null;
		
	    service=ContextFactory.getContext().getBean(FindYourCureServiceImpl.class);
	
	    try{
	    	  Patient  p=service.addPatient(patient);
			responseEntity =new ResponseEntity<Patient>(p,HttpStatus.OK);
		}
		catch(Exception e)
		{
			String error = environment.getProperty(e.getMessage());
			Patient ps = new Patient();
			ps.setMessage(error);
			responseEntity = new ResponseEntity<Patient>(ps,HttpStatus.BAD_REQUEST);
			
		}
		return responseEntity;
	
		
	}
	

	@RequestMapping(method=RequestMethod.POST, value="addDoctor")
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor)
	{
		environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<Doctor> responseEntity=null;
		
	    service=ContextFactory.getContext().getBean(FindYourCureServiceImpl.class);
	
	    try{
	    	  Doctor d=service.addDoctor(doctor);
			responseEntity =new ResponseEntity<Doctor>(d,HttpStatus.OK);
		}
		catch(Exception e)
		{
			String error = environment.getProperty(e.getMessage());
			Doctor d = new Doctor();
			d.setMessage(error);
			responseEntity = new ResponseEntity<Doctor>(d,HttpStatus.BAD_REQUEST);
			
		}
		return responseEntity;
	
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="loginPatient")
	public ResponseEntity<Patient> loginPatient(@RequestBody Patient patient){
		 environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<Patient> responseEntity=null;
		
		 service=ContextFactory.getContext().getBean(FindYourCureServiceImpl.class);
		 try{Patient patient1=service.loginPatient(patient);
			if(patient.getPid()==-1 ){
				throw new Exception("");
			}
			  responseEntity = new ResponseEntity<Patient>(patient1,HttpStatus.OK);
			 
		 }
		 catch(Exception exception) {
				
				Patient patient1=new Patient();
				patient1.setMessage("Invalid Credentials");			
				responseEntity = new ResponseEntity<Patient>(patient1,HttpStatus.BAD_REQUEST);		

			}
		return responseEntity;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="loginDoctor")
	public ResponseEntity<Doctor> loginDoctor(@RequestBody Doctor doctor){
		 environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<Doctor> responseEntity=null;
		
		 service=ContextFactory.getContext().getBean(FindYourCureServiceImpl.class);
		 try{Doctor doctor1=service.loginDoctor(doctor);
			if(doctor1.getDid()==-1){
				throw new Exception("");
			}
			  responseEntity = new ResponseEntity<Doctor>(doctor1,HttpStatus.OK);
			 
		 }
		 catch(Exception exception) {
				
				Doctor doctor1=new Doctor();
				doctor1.setMessage("Invalid Credentials");			
				responseEntity = new ResponseEntity<Doctor>(doctor1,HttpStatus.BAD_REQUEST);		

			}
		return responseEntity;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="updatePatient")
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient){

		Environment environment= ContextFactory.getContext().getEnvironment();
		
		service = (FindYourCureService) ContextFactory.getContext().getBean(FindYourCureServiceImpl.class);
		
		ResponseEntity<Patient> responseEntity;
		try {
			Patient patient1 = service.updatePatient(patient);
			patient1.setMessage(environment.getProperty("UPDATE_API.SUCCESSFULL"));
			responseEntity = new ResponseEntity<Patient>(patient1,HttpStatus.OK);

		}

		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			Patient pp = new Patient();
			pp.setMessage(errorMessage);
			responseEntity = new ResponseEntity<Patient>(pp,HttpStatus.BAD_REQUEST);

		}

		return responseEntity;

	}
	
	@RequestMapping(method=RequestMethod.POST, value="updateDoctor")
	public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor){

		Environment environment= ContextFactory.getContext().getEnvironment();
		
		service = (FindYourCureService) ContextFactory.getContext().getBean(FindYourCureServiceImpl.class);
		
		ResponseEntity<Doctor> responseEntity;
		try {
			Doctor doctor1 = service.updateDoctor(doctor);
			doctor1.setMessage(environment.getProperty("UPDATE_API.SUCCESSFULL"));
			responseEntity = new ResponseEntity<Doctor>(doctor1,HttpStatus.OK);

		}

		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			Doctor dd = new Doctor();
			dd.setMessage(errorMessage);
			responseEntity = new ResponseEntity<Doctor>(dd,HttpStatus.BAD_REQUEST);

		}

		return responseEntity;

	}
	@RequestMapping(method=RequestMethod.POST, value="updateAppointment")	
	public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment){

		Environment environment= ContextFactory.getContext().getEnvironment();
		
		service = (FindYourCureService) ContextFactory.getContext().getBean(FindYourCureServiceImpl.class);
		
		ResponseEntity<Appointment> responseEntity;
		try {
			Appointment ap = service.updateAppointment(appointment);
			
			responseEntity = new ResponseEntity<Appointment>(ap,HttpStatus.OK);

		}
		catch(Exception e){
			Appointment ap = new Appointment();
			ap.setMessage("Appid not found");
			responseEntity = new ResponseEntity<Appointment>(ap,HttpStatus.OK);
System.out.println("error ");
		}
		return responseEntity;
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="scheduleAppointment")
	public ResponseEntity<Appointment> scheduleAppointment(@RequestBody Appointment appointment)
	{
		environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<Appointment> responseEntity=null;
		
	    service=ContextFactory.getContext().getBean(FindYourCureServiceImpl.class);
	
	    try{
	    	
	    	Appointment  app=service.scheduleAppointment(appointment);
	    	
			responseEntity =new ResponseEntity<Appointment>(app,HttpStatus.OK);
		}
		catch(Exception e)
		{
			String error = environment.getProperty(e.getMessage());
			Appointment app = new Appointment();
			app.setMessage(error);
			responseEntity = new ResponseEntity<Appointment>(app,HttpStatus.BAD_REQUEST);
			
		}
		return responseEntity;
	
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="displayPatient/{id}")
	public ResponseEntity<Patient> displayPatient(@PathVariable("id") Integer pid){

		Environment environment= ContextFactory.getContext().getEnvironment();
		
		service = ContextFactory.getContext().getBean(FindYourCureServiceImpl.class);
		
		ResponseEntity<Patient> responseEntity;
		try {
			Patient patient = service.displayPatient(pid);
			responseEntity = new ResponseEntity<Patient>(patient,HttpStatus.OK);

		}

		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			Patient pc = new Patient();
			pc.setMessage(errorMessage);
			responseEntity = new ResponseEntity<Patient>(pc,HttpStatus.BAD_REQUEST);

		}

		return responseEntity;

	}

	@RequestMapping(method=RequestMethod.POST, value="getSpecialization")
	public ResponseEntity<String> getSpecialization (@RequestBody Appointment appointment)
	{
		environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<String> responseEntity=null;
		
	    service=ContextFactory.getContext().getBean(FindYourCureServiceImpl.class);
	
	    try{
	    	
	    	String spec=service.getSpecialization(appointment);
	    	
			responseEntity =new ResponseEntity<String>(spec,HttpStatus.OK);
		}
		catch(Exception e)
		{
			String error = environment.getProperty(e.getMessage());
			String app =error;
			
			
			responseEntity = new ResponseEntity<String>(app,HttpStatus.BAD_REQUEST);
			
		}
		return responseEntity;
	
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="getDoctorList1")
	public  ResponseEntity<List<Doctor>> getDoctorList1 (@RequestBody Appointment appointment)
	{
		environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<List<Doctor>> responseEntity=null;
		
	    service=ContextFactory.getContext().getBean(FindYourCureServiceImpl.class);
	
	    try{
	    	
	    	Appointment ap2=new Appointment();
	    	ap2.setSymptom1(appointment.getSymptom1());
    	List<Doctor> doclist1=service.getDoctorList1(ap2);
    	List<Doctor> doclist3=new ArrayList<Doctor>();
    	
    	doclist3.addAll(doclist1);
	    	Appointment ap = new Appointment();
	    	
	    	ap.setSymptom2(null);
	    	
	    	ap.setSymptom1(appointment.getSymptom2());
	    	if(ap.getSymptom1()!=null)
	    	{
		    	List<Doctor> doclist2=service.getDoctorList1(ap);
		   
		    	
////////////////////////////////////////////////
			System.out.println(doclist1.size());
			System.out.println(doclist2.size());
		    for( Doctor d2 : doclist2)
		    {	
		    	
		    	for(Doctor d1 :doclist1){
		    		System.out.println("Inside for loop 1");
		    		System.out.println("d1= "+d1.getDid()+" d2= "+d2.getDid()+" "+(d1.getDid().equals(d2.getDid())));
		    	if(d1.getDid().equals(d2.getDid())){
		    	System.out.println("Inside if");
		    		doclist3.remove(d1);
		    		
		    	}}}
		    	doclist3.addAll(doclist2);

	    		
		    }
	    	

	    
			responseEntity =new ResponseEntity<List<Doctor>>(doclist3,HttpStatus.OK);
		}
		catch(Exception e)
		{
			String error = environment.getProperty(e.getMessage());
			List<Doctor> app = new ArrayList<>();
			
			
			responseEntity = new ResponseEntity<List<Doctor>>(app,HttpStatus.BAD_REQUEST);
			
		}
		return responseEntity;
	
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="getDoctorList2")
	public  ResponseEntity<List<Doctor>> getDoctorList2 (@RequestBody Appointment appointment)
	{
		environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<List<Doctor>> responseEntity=null;
		
	    service=ContextFactory.getContext().getBean(FindYourCureServiceImpl.class);
	
	    try{
	    	
	    	List<Doctor> doclist1=service.getDoctorList2(appointment);
	    	
			responseEntity =new ResponseEntity<List<Doctor>>(doclist1,HttpStatus.OK);
		}
		catch(Exception e)
		{
			String error = environment.getProperty(e.getMessage());
			List<Doctor> app = new ArrayList<>();
			
			
			responseEntity = new ResponseEntity<List<Doctor>>(app,HttpStatus.BAD_REQUEST);
			
		}
		return responseEntity;
	
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="showAllPatients")
	public ResponseEntity<List<Patient>> showAllPatients(){
		
		Environment environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<List<Patient>> responseEntity=null;

		List<Patient> allPatients=new ArrayList<Patient>();
		service = (FindYourCureService) ContextFactory.getContext().getBean(FindYourCureServiceImpl.class);
		
		try {
			allPatients=service.showAllPatients();
			responseEntity = new ResponseEntity<>(allPatients,HttpStatus.OK);

		}


		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			Patient patient = new Patient();
			patient.setMessage(errorMessage);			
			allPatients.add(patient);			
			responseEntity = new ResponseEntity<>(allPatients,HttpStatus.BAD_REQUEST);
			

		}

		return responseEntity;

	}
	
	@RequestMapping(method=RequestMethod.GET, value="showAllDoctors")
	public ResponseEntity<List<Doctor>> showAllDoctors(){
		
		Environment environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<List<Doctor>> responseEntity=null;

		List<Doctor> allDoctors=new ArrayList<Doctor>();
		service = (FindYourCureService) ContextFactory.getContext().getBean(FindYourCureServiceImpl.class);
		
		try {
			allDoctors=service.showAllDoctors();
			responseEntity = new ResponseEntity<>(allDoctors,HttpStatus.OK);

		}


		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			Doctor doc = new Doctor();
			doc.setMessage(errorMessage);			
			allDoctors.add(doc);			
			responseEntity = new ResponseEntity<>(allDoctors,HttpStatus.BAD_REQUEST);
			

		}

		return responseEntity;

	}
	
	/////////////////////////////////////////////////
	//getdid
	//////////////////////////////////////////////////////
	@RequestMapping(method=RequestMethod.POST, value="getDoc/{did}")
	public  ResponseEntity<Doctor> getDoc(@PathVariable Integer did)
	{
	environment= ContextFactory.getContext().getEnvironment();
	ResponseEntity<Doctor> responseEntity=null;
	Doctor doctor = new Doctor();
	doctor.setDid(did);
	service=ContextFactory.getContext().getBean(FindYourCureServiceImpl.class);
	try
	{
	Doctor doctor1=service.getDoc(doctor);
	if(doctor1.getDid()==null){
	throw new Exception("");
	}
	responseEntity = new ResponseEntity<Doctor>(doctor1,HttpStatus.OK);
	
	}
	catch(Exception exception) {
	
	Doctor doctor1=new Doctor();
	doctor1.setMessage("Invalid Credentials");			
	responseEntity = new ResponseEntity<Doctor>(doctor1,HttpStatus.BAD_REQUEST);		
	
	}
	return responseEntity;
	
	}
	
	
	///////////////////////////////////////////////////////////////////
	//delete doctor//
	/////////////////////////////////////////////////////////////////
	
	@DeleteMapping("/deleteDoctor/{did}")
	public  ResponseEntity<String> deleteDoctor(@PathVariable Integer did)
	{
	
	ResponseEntity<String> responseEntity=null;
	service=ContextFactory.getContext().getBean(FindYourCureServiceImpl.class);
	try
	{
	System.out.println(did);
	service.deleteDoctor(did);
	
	String message = "Doctor Deleted";
	responseEntity = new ResponseEntity<String>(message,HttpStatus.OK);
	}
	catch(Exception e)
	{
	System.out.println();
	String message = "Error present";
	System.out.println("/n/n/n/n/n/n/n"+"  "+e.getMessage());
	responseEntity = new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
	}
	
	
	return responseEntity;
	
	
	
	}
	
	
	////////////////////////////////////////////
	///delete patient
	///////////////////////////////////////////
	
	
	@DeleteMapping("/deletePatient/{pid}")
	public  ResponseEntity<String> deletePatient(@PathVariable Integer pid)
	{
	ResponseEntity<String> responseEntity=null;
	service=ContextFactory.getContext().getBean(FindYourCureServiceImpl.class);
	try
	{
	System.out.println(pid);
	service.deletePatient(pid);
	
	String message = "Doctor Deleted";
	responseEntity = new ResponseEntity<String>(message,HttpStatus.OK);
	}
	catch(Exception e)
	{
	System.out.println();
	String message = "Error present";
	System.out.println("/n/n/n/n/n/n/n"+"  "+e.getMessage());
	responseEntity = new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
	}
	return null;}

/////////////////////////////////////
///getAppointment
////////////////////////////////////
@RequestMapping(method=RequestMethod.POST, value="getAppid/{did}")
public  ResponseEntity<List<Appointment>> getAppointment(@PathVariable Integer did)
{
ResponseEntity<List<Appointment>> responseEntity=null;
service=ContextFactory.getContext().getBean(FindYourCureServiceImpl.class);
List<Appointment> a = new ArrayList();
try
{ a = service.getAppointmentId(did);
System.out.println("  size of a  "+a.size());
responseEntity = new ResponseEntity<List<Appointment>>(a,HttpStatus.OK);
}
catch(Exception e){
responseEntity =new ResponseEntity<List<Appointment>>(a,HttpStatus.BAD_REQUEST);
}
return responseEntity;	
}

@RequestMapping(method=RequestMethod.POST, value="getPatientApp/{appid}")
public  ResponseEntity<Patient> getPatientApp(@PathVariable Integer appid){
	ResponseEntity<Patient> responseEntity = null	;
	service=ContextFactory.getContext().getBean(FindYourCureServiceImpl.class);
	try
	{Patient a = service.getPatientByAppId(appid);
	
	responseEntity = new ResponseEntity<Patient>(a,HttpStatus.OK);
	}
	catch(Exception e){
		Patient a=new Patient();
		a.setMessage(e.getMessage());
		responseEntity = new ResponseEntity<Patient>(a,HttpStatus.BAD_REQUEST);
	}
	return responseEntity;
}


}
