package com.cg.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entities.Buyer;
import com.cg.entities.Preference;
import com.cg.exception.PersonNotFoundException;
import com.cg.repositories.BuyerRepository;

@Service
public class BuyerService {
	
		@Autowired
		BuyerRepository buyerRepository;
	
	    public String setAppointmentDate(long personId,LocalDate date) throws PersonNotFoundException{
	    	if(!buyerRepository.existsById(personId)) {
	    		throw new PersonNotFoundException("Person not found!!");
	    	}
	    	else {
	    		Buyer buyer = buyerRepository.findById(personId).get();
	    		buyer.setAppointmentDate(date);
	    	
	    		buyerRepository.save(buyer);
	    		return "Appointment is set on "+date;
	    		}
	    }
	
	    public String getAppointmentDateAndTime(long personId) throws PersonNotFoundException{
		    if(!buyerRepository.existsById(personId)) {
		    	throw new PersonNotFoundException("Person not found!!");
		    }
		    else {
		    	Buyer buyer = buyerRepository.findById(personId).get();
				LocalDate date = buyer.getAppointmentDate();
				LocalTime time = buyer.getAppointmentTime();
				return "Appointment for buyer with ID " + personId + " is on " + date +" "+time;  
		    }
	     }
	
		public Preference getPreferences(long personId) throws PersonNotFoundException{
		    if(!buyerRepository.existsById(personId)) {
		    	throw new PersonNotFoundException("Person not found!!");
		    }
		    else {
		    	Buyer buyer = buyerRepository.findById(personId).get();
		    	Preference preferences = buyer.getPreferences();
		    	return preferences;
		    }
		}
	
		
		public List<Buyer> getAllBuyers(){
			
			return buyerRepository.findAll();
			
		}
		
		public ResponseEntity<Object> deleteBuyer(long personId)throws PersonNotFoundException{
		    if(!buyerRepository.existsById(personId)) {
		    	throw new PersonNotFoundException("Person not found!!");
		    }
		    else {
		    	buyerRepository.deleteById(personId);
		    	return new ResponseEntity<>("record deleted successfully",HttpStatus.OK);
		    }
		}
		
		public List<Buyer> changePreferences(long personId, Preference preferences)throws PersonNotFoundException{
		    if(!buyerRepository.existsById(personId)) {
		    	throw new PersonNotFoundException("Person not found!!");
		    }
		    else {
		    	Buyer buyer = buyerRepository.findById(personId).get();
		    	buyer.setPreferences(preferences);
		    	buyerRepository.save(buyer);
		   		return buyerRepository.findAll(); 
		    }
		}
		
		public Buyer addBuyer(Buyer buyer)
		{
			return buyerRepository.save(buyer);
		}
		
		public boolean existOrNot(long id)
		{
			return buyerRepository.existsById(id);
		}
		
		
}
