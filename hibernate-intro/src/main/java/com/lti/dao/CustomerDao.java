package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Customer;

public class CustomerDao {

	public void add(Customer customer) {
		EntityManagerFactory emf=null;
		EntityManager em =null;
		try {
		//Step 1.Create/Obtain EntityManagerFactory object
		//During this step, META-INF/persistence.xml file will be read
		
	emf= Persistence.createEntityManagerFactory("oracleTest");
     
		
		//Step 2. Create/Obtain EntityManager object
		//this step is similar to opening a Connection
		//In regular JDBC code
		em = emf.createEntityManager();
		
		// step 3. start/participate in a transaction
		EntityTransaction tx=em.getTransaction();
		
		tx.begin();
		
		//now we can insert or update or delete or select operations
		em.persist(customer);  //persist method generates insert query
		
		tx.commit();
		}
		finally
		{
		// below code should be in finally block
		emf.close();
		em.close();
		}
		
	}
	public void update(Customer customer) {
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("oracleTest");
        EntityManager em = emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.merge(customer);  //merge method generates update query
		
		tx.commit();
		emf.close();
		em.close();
	}
	public Customer fetchById(int id) {
		EntityManagerFactory emf= null; //Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em = null; //createEntityManager();
		try {
		emf=Persistence.createEntityManagerFactory("oracleTest");
		 em =emf.createEntityManager();
		 Customer cust=em.find(Customer.class,id);
		 return cust;
		}
		finally {
		//find method generates select query
		em.close();
		emf.close();}
		
	}
	public List<Customer> fetchByCity(String vizag) {
		EntityManagerFactory emf=null; //Persistence.createEntityManagerFactory("oracleTest");
        EntityManager em =null; //emf.createEntityManager();
        try {
        emf= Persistence.createEntityManagerFactory("oracleTest");
        em = emf.createEntityManager();
        
        //introducing JPQL/HQL
        String query="select cust from Customer cust where cust.city=:ct ";
        Query q=em.createQuery(query);
        q.setParameter("ct", vizag);
       
        List<Customer> list=q.getResultList();
         return list;
        }
        finally {
         em.close();
          emf.close();
        }
	}
}
