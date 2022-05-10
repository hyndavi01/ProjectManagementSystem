package com.cg.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entities.Property;
import com.cg.exception.PropertyNotFoundException;
import com.cg.services.PropertyService;




@RestController
public class PropertyController {
	
     @Autowired
     private PropertyService ps; 
    
     @GetMapping("/allProperty")
     public ResponseEntity<Object> getAllProperty() throws PropertyNotFoundException{

    	 return ps.getAllProperty();
     }
     @PostMapping("/addProperty")
  	public ResponseEntity<?> addProperty(@Valid @RequestBody Property property){

  		Object addedProperty = ps.addProperty(property);
  		return new ResponseEntity<Object>(addedProperty,HttpStatus.CREATED);
  	}

     @GetMapping("/findProperty/{id}")
     public ResponseEntity<Object> findProperty(@PathVariable("id") long id) throws PropertyNotFoundException {
 	 
    	 return ps.findProperty(id);   
   }
     
     @GetMapping("/propertyType/{type}")
     
     public ResponseEntity<Object> findPropertyByType(@PathVariable("type") String type )throws PropertyNotFoundException{
   
  	   return ps.findPropertyType(type);
     }
     @GetMapping("/propertyAvl/{purpose}")
     public List<Property> findPropertyByAvalability(@PathVariable("purpose") String purpose ){
  	   return ps.findPropertyAvalability(purpose);
     }
     @GetMapping("/propertyPrice/{purpose}/{type}/{price}")
     public List<Property> findPropertyByPrice(@PathVariable("purpose") String purpose , @PathVariable("type") String type ,@PathVariable("price") double price){
  	   return ps.findPropertyByPrice(purpose,type ,price);
     }
    
     @GetMapping("/propertySortByPrice")
     public List<Property> getAllPropertySortedByPrice(){

    	 return ps.getAllPropertySortedByPrice();
     }
     
   
     
     @DeleteMapping("/delProperty/{id}")
     public ResponseEntity<?> deleteProperty(@PathVariable("id") long  id) throws PropertyNotFoundException { 	
    	 String output =  ps.deleteProperty(id);
    	 return new ResponseEntity<Object>(output,HttpStatus.OK);
     }
    
}