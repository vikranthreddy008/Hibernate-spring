package com.lti.service;

import java.util.Set;

import com.lti.dao.GenericDao;
import com.lti.entity.Cart;
import com.lti.entity.Item;
import com.lti.entity.Product;
import com.lti.entity.User;

public class ShoppingService {
	public void addProduct(Product product) {
		GenericDao dao=new GenericDao();
		dao.save(product);
		
	}

	public void createCart(int userId) {
		GenericDao dao= new GenericDao();
		User u= dao.fetchById(User.class, userId);
		Cart c=new Cart();
		c.setUser(u);
		dao.save(c);
		
	}
	public void addToCart( int cartId, int productId, int quantity) {
		GenericDao dao= new GenericDao();
		Cart c=dao.fetchById(Cart.class, cartId);
		Product p=dao.fetchById(Product.class, productId);
		Item i=new Item();
		i.setCart(c);
		i.setProduct(p);
		i.setQuantity(quantity);
		dao.save(i);
		 c.setTotal(c.getTotal()+ p.getPrice() * quantity);
		 dao.save(c);
		 p.setStock(p.getStock()-quantity);
		 dao.save(p);
		 
}
	public void deleteCart(int cartId) {
		GenericDao dao= new GenericDao();
		Cart c=dao.fetchById(Cart.class, cartId);
		Set<Item> items=c.getItems();
		for(Item item : items) {
			Product prod=item.getProduct();
			prod.setStock(prod.getStock()+item.getQuantity());
			dao.save(prod);
		}
	
       dao.delete(Cart.class, cartId);
		
	
}
}