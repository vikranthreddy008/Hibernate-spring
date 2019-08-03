package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Song;
import com.lti.entity.Transaction;

public class AlbumDao extends GenericDao{
	public List<Song>fetchMini(int sngno){
		
		EntityManagerFactory emf=null;
		EntityManager em =null;
		try {
			emf= Persistence.createEntityManagerFactory("oracleTest");
			em = emf.createEntityManager();
			
			String query="";
			//String query="select a from Account a where acno=222";
			Query q=em.createQuery(query);
			q.setParameter("ac",sngno);
			q.setMaxResults(5);
			return q.getResultList();
		}
		finally
		{
			emf.close();
			em.close();
		}
		}

	}



