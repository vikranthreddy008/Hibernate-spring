package com.lti.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lti.dao.ProductDao;
import com.lti.entity.Product;

@Controller

public class ProductController {
	
	@Autowired
	private ProductDao dao;
	
	@RequestMapping("/searchProduct.lti")
	public String hello(@RequestParam("productId") int productId, Map<String, Object> model) {
	
		Product prod = dao.fetchById(productId);
		model.put("productData", prod);
		return "searchProductResult.jsp";
		
	}
	@RequestMapping("/fetchAllProducts.lti")
	public String fetchAll(Map<String, Object> model) {
		List<Product> list = dao.fetchAll();
		model.put("listOfProducts", list);
		return "listOf Products.jsp";
	}

	@RequestMapping("/addProduct.lti")
	public String add(Product product, Map<String, Object> model) {
		dao.save(product);
		model.put("message", "product added successfully");
		return "addProduct.jsp";
		
	}
}
