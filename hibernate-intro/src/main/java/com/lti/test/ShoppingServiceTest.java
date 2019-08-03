package com.lti.test;

import org.junit.Test;

import com.lti.entity.Cart;
import com.lti.entity.Product;
import com.lti.service.ShoppingService;

public class ShoppingServiceTest {
	
	@Test
	public void addProduct() {
		Product p=new Product();
		p.setName("one+");
		p.setPrice(15000);
		p.setStock(20);
		
		ShoppingService s=new ShoppingService();
		s.addProduct(p);
	}
	@Test
	public void createCart() {
		ShoppingService s=new ShoppingService();
		s.createCart(143);
		Cart c=new Cart();
		c.setItems("mobiles");
		c.setTotal(5);

	}
	@Test
	public void addCart() {
		ShoppingService s=new ShoppingService();
	s.addToCart(303, 304, 5);
	
	}

	@Test
	public void deleteCart() {
		ShoppingService s=new ShoppingService();
		s.deleteCart(303);
		
		
		
		
		
	}	
	}

