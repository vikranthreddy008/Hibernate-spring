package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_PASSPORT")
public class Passport {
	@Id
	@GeneratedValue
private int id;
private LocalDate dob;
private String country;



@OneToOne
@JoinColumn(name="U_ID")  //foreign key column
private User user;


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public LocalDate getDob() {
	return dob;
}
public void setDob(LocalDate dob) {
	this.dob = dob;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
}