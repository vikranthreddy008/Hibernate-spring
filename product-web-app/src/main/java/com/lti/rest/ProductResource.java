package com.lti.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import com.lti.dao.GenericDao;
import com.lti.entity.Product;


@Path("/product")
public class ProductResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct(@QueryParam("id") int productId)  {

		GenericDao dao=new GenericDao();
		Product p=dao.fetchById(Product.class, productId);
		return p;
    }
	
	
	@Path("/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Status addProduct(Product product) {
		GenericDao dao =new GenericDao();
		dao.save(product);
		 
		Status status=new Status();
		status.setMessage("product added successfully!!!!!!!!!!!!!!!!!!!");
		return status;
		
	 }
	
	public class Status{
		private String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
	
  }
