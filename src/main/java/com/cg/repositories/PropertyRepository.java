package com.cg.repositories;

import java.util.List;
import java.util.Properties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entities.Property;
@Repository
public interface PropertyRepository  extends JpaRepository<Property, Long>{

//   @Query(value = "select p.propertyId , p.propertyName , p.type , p.sellOrRent , p.price , p.area  From Property p ")
//   public List<Object> getALLProperty();
  
	 @Query("Select property From Property property where property.type =:type")
	   public List<Property> findByType(@Param("type") String type);
	     
	   @Query("Select property From Property property where property.sellOrRent =:available")
	   public List<Property> findByAvailability(@Param("available") String purpose);
	     
	   @Query("Select property From Property property where property.sellOrRent =:available and property.type =:type and property.price <=:price")
	   public List<Property> findByPrice(@Param("available") String purpose,@Param("type") String type,@Param("price") double price);

	   public Property findByPropertyName(String name);

}
