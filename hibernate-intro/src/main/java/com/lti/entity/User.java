package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_USER")
public class User {
	
	@Id
	@GeneratedValue

	private int id;
	
	
	private String name;
	private String email;
	
	//has-a relationship
	@OneToOne(mappedBy="user" , cascade= CascadeType.ALL)
	private Address address;
	
	@OneToOne(mappedBy="user" , cascade= CascadeType.ALL)
	private  Passport passport;
	
	
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	}

	
	
	

