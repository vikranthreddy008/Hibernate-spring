package com.lti.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

@Controller
public class CustomerController {


	
	@Autowired
	private CustomerDao dao;
	
	@RequestMapping("/searchCustomer.lti")
	public String hello(@RequestParam("customerId") int customerId, Map<String, Object> model) {
	
		Customer cs = dao.fetchById(customerId);
		model.put("customerData", cs);
		return " searchCustomerResult.jsp";
		
	}
}



