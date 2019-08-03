package com.lti.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.User;

public class UserDao extends GenericDao {
	
	public List<User>fetchByCity(String city) {
		
		EntityManagerFactory emf=null;
		EntityManager em =null;
		try {
			emf= Persistence.createEntityManagerFactory("oracleTest");
			em = emf.createEntityManager();
			
			String query="select u from User as u " +" "+" where u.address.city=:ct";
			Query q=em.createQuery(query);
			q.setParameter("ct",city);
			return q.getResultList();
		}
		finally
		{
			emf.close();
			em.close();
		}
		}

	public List<User> fetchByDob(LocalDate dob) {
		EntityManagerFactory emf=null;
		EntityManager em =null;
		try {
			emf= Persistence.createEntityManagerFactory("oracleTest");
			em = emf.createEntityManager();
			
			String query="select u from User as u where u.passport.dob=:dt";
			Query q=em.createQuery(query);
			q.setParameter("dt",dob);
			return q.getResultList();
		}
		finally
		{

			
			emf.close();
			em.close();
		}
		}
	public List<Object[]> fetchUserInfo(){
		EntityManagerFactory emf=null;
		EntityManager em =null;
		try {
			emf= Persistence.createEntityManagerFactory("oracleTest");
			em = emf.createEntityManager();
			
			String query="select u.name, a.city, p.country" + " from User u join u.address a join u.passport p";
			Query q=em.createQuery(query);
			
			return q.getResultList();
		}
		finally
		{
			emf.close();
			em.close();
		}
	 }

	
	
	
	
	
	
	}
	
	
	
	
	
	
	




		
	


