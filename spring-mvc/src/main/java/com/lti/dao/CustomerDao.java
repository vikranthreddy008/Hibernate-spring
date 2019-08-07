package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.lti.entity.Customer;


@Component
public class CustomerDao {
		
		@PersistenceContext
		private EntityManager entityManager;
		
		public Customer fetchById(int customerId) {
		
			return entityManager.find(Customer.class, customerId);
		}	

}
