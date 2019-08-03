package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_ITEM")
public class Item { 
	
	@Id
	@GeneratedValue
	private int id;
	


@ManyToOne
@JoinColumn(name="CART_ID")
private Cart cart;

private int quantity;

@ManyToOne
@JoinColumn(name="PRODUCT_ID")
private Product product;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public Cart getCart() {
	return cart;
}
public void setCart(Cart cart) {
	this.cart = cart;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

}
