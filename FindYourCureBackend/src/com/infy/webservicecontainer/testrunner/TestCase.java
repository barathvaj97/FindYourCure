//package com.infy.webservicecontainer.testrunner;
//
//import org.springframework.http.ResponseEntity;
//
//import com.infy.api.UDAIApi;
//import com.infy.model.AadharCard;
//import com.infy.model.FlightsBooking;
//
//public class TestCase {
//
//	public float testAddBookingPositive() throws Exception {
//		float marks = 0.0f;
//
//		try {
//			UDAIApi flightBookingApi = new UDAIApi();
//			FlightsBooking flightsBooking = new FlightsBooking();
//			AadharCard aadharCard = new AadharCard();
//			aadharCard.setFlightId(1005);
//
//			flightsBooking.setPassengerName("Alex");
//			flightsBooking.setNoOfTickets(2);
//			flightsBooking.setFlights(aadharCard);
//
//			ResponseEntity<FlightsBooking> responseEntity = flightBookingApi.addBooking(flightsBooking);
//			Integer dataFromApi = responseEntity.getBody().getBookingId();
//			Integer expectedDataFromApi = 2011;
//
//			if (dataFromApi.equals(expectedDataFromApi)) {
//				marks = (float) 3.75;
//				// put marks here
//			} else {
//				throw new Exception("Actual Value is: " + dataFromApi
//						+ " but Expected Value was: " + expectedDataFromApi);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			
//			throw e;
//		}
//
//		return marks;
//	}
//
//	
//	public float testAddBookingStatusPositive() throws Exception{
//		float marks = 0.0f;
//		
//		
//		try{
//			UDAIApi flightBookingApi = new UDAIApi();
//			FlightsBooking flightsBooking = new FlightsBooking();
//			AadharCard aadharCard = new AadharCard();
//			aadharCard.setFlightId(1005);
//
//			flightsBooking.setPassengerName("Alex");
//			flightsBooking.setNoOfTickets(2);
//			flightsBooking.setFlights(aadharCard);
//			ResponseEntity<FlightsBooking> responseEntity = flightBookingApi.addBooking(flightsBooking);
//			if(responseEntity.getStatusCodeValue() == 200){
//				marks = (float) 3.75;
//				// put marks here
//			}else{
//				throw new Exception("Actual Status is: " + responseEntity.getStatusCodeValue() + " but Expected Status was: " + 200);
//			}
//		}catch(Exception e){
//			throw e;
//		}
//		
//		return marks;
//	}
//	
//	public float testAddBookingNegative() throws Exception{
//		float marks = 0.0f;
//		
//		
//		try{
//			UDAIApi flightBookingApi = new UDAIApi();
//			FlightsBooking flightsBooking = new FlightsBooking();
//			AadharCard aadharCard = new AadharCard();
//			aadharCard.setFlightId(1005);
//
//			flightsBooking.setPassengerName("Alex");
//			flightsBooking.setNoOfTickets(9);
//			flightsBooking.setFlights(aadharCard);
//
//			ResponseEntity<FlightsBooking> responseEntity = flightBookingApi.addBooking(flightsBooking);
//			String dataFromApi = responseEntity.getBody().getMessage();
//			String expectedDataFromApi = "Requested number of seats are unavailable";
//			if(dataFromApi.equals(expectedDataFromApi)){
//				marks = (float) 3.75;
//				// put marks here
//			}else{
//				throw new Exception("Actual Value is: " + dataFromApi + " but Expected Value was: " + expectedDataFromApi);
//			}
//		}catch(Exception e){
//			throw e;
//		}
//		
//		return marks;
//	}
//	
//	public float testAddBookingStatusNegative() throws Exception{
//		float marks = 0.0f;
//		
//		
//		try{
//			UDAIApi flightBookingApi = new UDAIApi();
//			FlightsBooking flightsBooking = new FlightsBooking();
//			AadharCard aadharCard = new AadharCard();
//			aadharCard.setFlightId(1005);
//
//			flightsBooking.setPassengerName("Alex");
//			flightsBooking.setNoOfTickets(9);
//			flightsBooking.setFlights(aadharCard);
//			ResponseEntity<FlightsBooking> responseEntity = flightBookingApi.addBooking(flightsBooking);
//			if(responseEntity.getStatusCodeValue() == 400){
//				marks = (float) 3.75;
//				// put marks here
//			}else{
//				throw new Exception("Actual Status is: " + responseEntity.getStatusCodeValue() + " but Expected Status was: " + 400);
//			}
//		}catch(Exception e){
//			throw e;
//		}
//		
//		return marks;
//	}
//
//}
