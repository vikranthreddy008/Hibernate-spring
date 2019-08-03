package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.entity.Customer;
import com.lti.entity.User;

public class GenericDao {

	public void save(Object object) {
		
		
		EntityManagerFactory emf=null;
		EntityManager em =null;
		try {
			emf= Persistence.createEntityManagerFactory("oracleTest");
			em = emf.createEntityManager();
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.merge(object); 
			//merge is actually a 2-in-1 method
			//can be used for insert as well as update method.....
			tx.commit();

		}
		finally
		{
		
		emf.close();
		em.close();
		}
	}
		//public  Object fetchById(Class clazz, Object pk) {
			public  <E> E fetchById(Class<E> clazz, Object pk) {
			EntityManagerFactory emf= null; //Persistence.createEntityManagerFactory("oracleTest");
			EntityManager em = null; //createEntityManager();
			try {
			emf=Persistence.createEntityManagerFactory("oracleTest");
			 em =emf.createEntityManager();
			//Object obj= em.find(clazz, pk);
			 E e=em.find(clazz, pk);
			 return e;

			}
			finally {
			//find method generates select query
			em.close();
			emf.close();}
			
		}
			
			public void delete(Class clazz,Object pk) {
				
				
				EntityManagerFactory emf=null;
				EntityManager em =null;
				try {
					emf= Persistence.createEntityManagerFactory("oracleTest");
					em = emf.createEntityManager();
					EntityTransaction tx=em.getTransaction();
					tx.begin();
					Object obj=em.find(clazz, pk);
					em.remove(obj); 

					tx.commit();

				}
				finally
				{
				
				emf.close();
				em.close();
				}
			}
	}

