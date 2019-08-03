package com.lti.test;

import java.util.List;

import org.junit.Test;

import com.lti.dao.CustomerDao;
import com.lti.entity.Account;
import com.lti.entity.Customer;
import com.lti.service.AccountService;

public class CustomerTesting {
	//public static void main(String args[])
	@Test
	public void testAdd()
	{
		Customer cust=new Customer();
		cust.setName("viky");
		cust.setEmail("vikranth009@gmail.com");
		cust.setCity("Hyd");
		cust.setPassword("viky");
	
		/*we r not adding id because we need to generate auto 
		primary key so we need hibernate to add id*/
		CustomerDao dao=new CustomerDao();
		dao.add(cust);
		
	}
	@Test
	public void testFetchById() {
		CustomerDao dao=new CustomerDao();
		Customer cust=dao.fetchById(1);
		System.out.println(cust.getName());
System.out.println(cust.getEmail());	
	System.out.println(cust.getCity());
	}
	@Test
	public void testUpdate() {
		CustomerDao dao= new CustomerDao();
		Customer cust= dao.fetchById(21);
		cust.setCity("banglore");
		dao.update(cust);
	}
	@Test
	public void testFetchByCity() {
		CustomerDao dao=new CustomerDao();
		List<Customer> list= dao.fetchByCity("vizag");
		
		for(Customer cust : list) {
			System.out.println(cust.getName());
			System.out.println(cust.getEmail());
			System.out.println(cust.getCity());
			
		}
		
			}
	@Test
	public void miniStatement() {
		
	}
	
	}
	


