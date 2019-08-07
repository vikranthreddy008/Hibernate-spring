package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.lti.entity.Product;

@Component

public class ProductDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void save(Product product) {
		entityManager.persist(product);
	}
	public Product fetchById(int productid) {
		return entityManager.find(Product.class, productid);
	}
	
	public List<Product> fetchAll(){
		return entityManager.createQuery("select p from Product p").getResultList();
	}

}
