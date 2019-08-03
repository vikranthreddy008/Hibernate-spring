package com.lti.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="TBL_ACC_TX")

public class Transaction {
	
	@Id
	@GeneratedValue
private int txno;
	@Column(name="TX_TYPE")
private String type;
	
private LocalDateTime dateAndTime;
private double amount;

@ManyToOne
@JoinColumn(name="ACNO")
private Account account;

public int getTxno() {
	return txno;
}

public void setTxno(int txno) {
	this.txno = txno;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public LocalDateTime getDateAndTime() {
	return dateAndTime;
}

public void setDateAndTime(LocalDateTime dateAndTime) {
	this.dateAndTime = dateAndTime;
}

public double getAmount() {
	return amount;
}

public void setAmount(double amount) {
	this.amount = amount;
}

public Account getAccount() {
	return account;
}

public void setAccount(Account account) {
	this.account = account;
}

}


