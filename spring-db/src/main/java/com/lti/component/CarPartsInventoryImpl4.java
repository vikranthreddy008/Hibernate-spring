package com.lti.component;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component("carParts4")

public class CarPartsInventoryImpl4 implements CarPartsInventory {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
     public void addNewPart(CarPart carPart) {
    	 
    	 entityManager.persist(carPart);
    	 
     }
		
	public List<CarPart> getAvailableParts() {
		
		Query query=entityManager.createQuery("select c from CarPart c");
		
		
		return query.getResultList();
		
         }
 	 }

		
	
  





