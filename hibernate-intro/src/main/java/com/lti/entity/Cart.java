package com.lti.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_CART")
public class Cart {
	


	@Id
	@GeneratedValue
	private int  id;
	
	private double total;
	
	@OneToOne
	private User user;
	
	@OneToMany(mappedBy="cart", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Item> items;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	public void setItems(String string) {
		// TODO Auto-generated method stub
		
	}
	

}
