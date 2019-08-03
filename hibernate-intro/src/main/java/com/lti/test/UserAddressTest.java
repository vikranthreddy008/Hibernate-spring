package com.lti.test;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.dao.UserDao;
import com.lti.entity.Account;
import com.lti.entity.Address;
import com.lti.entity.Passport;
import com.lti.entity.User;
import com.lti.service.AccountService;

public class UserAddressTest {
@Test
public void addNewUser() {
	User user=new User();
	user.setName("viky");
	user.setEmail("vikranth009@gmail.com");
	
	user.setName("Naveen");
	user.setEmail("Naveen009@gmail.com");
	
	GenericDao dao=new GenericDao();
	dao.save(user);
	
	}

	@Test
	public void addAddressForAnExistingUser() {
		
		Address address=new Address();
		address.setStreet("sector4");
		address.setCity("mumbai");
		address.setState("MH");
		address.setPincode(500222);
		
		GenericDao dao=new GenericDao();
		User user=dao.fetchById(User.class, 141);
		address.setUser(user);
		dao.save(address);
	}
	
	@Test
	public void addUserAndTogether() {
		
		User user=new User();
		user.setName("vicky");
       user.setEmail("vicky@hhh.com");
       
       Address address=new Address();
       address.setStreet("gh");
       address.setCity("navi mu");
       address.setState("ap");
       address.setPincode(523112);
       
       user.setAddress(address);
       address.setUser(user);
       
       GenericDao dao=new GenericDao();
       dao.save(user);
       }
	
	@Test
	public void addUserAddressAndPassport() {
		 
		    User user=new User();
		    user.setName("sai");
	        user.setEmail("sai@009.com");
	       
	       Address address=new Address();
	       address.setStreet("kop");
	       address.setCity("navi mu");
	       address.setState("ap");
	       address.setPincode(523113);
	       
	       Passport pass=new Passport();
	       pass.setDob(LocalDate.of(1998, 12, 31));
	       pass.setCountry("India");
	      
	     
	       
	       user.setAddress(address);
	       address.setUser(user);
	       pass.setUser(user);
	       user.setPassport(pass);
	    
	       GenericDao dao=new GenericDao();
	       dao.save(user);
		
	}


	private LocalDate LocalDateOf(int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void fetchUsersByCity() {
		UserDao dao=new UserDao();
		List<User> users=dao.fetchByCity("delhi");
		for(User user: users)
		{
			System.out.println(user.getName());
			System.out.println(user.getEmail());
		
		}
		}
		
		@Test
		public void fetchUsersByPassportDob() {
			UserDao dao=new UserDao();
			
		LocalDate date=LocalDate.of(1998, 12, 31);
		List<User> users=dao.fetchByDob(date);
		
		for(User user: users) {
			System.out.println(user.getName());
			System.out.println(user.getEmail());
		}
		}
		@Test
		public void fetchByAll() {
			UserDao usd= new UserDao();
			List<Object[]> result=usd.fetchUserInfo();
			for(Object[] user:result) {
				System.out.println("=======USER DETAILS======");
				System.out.println("Name:" +user[0]);
				System.out.println("city:" +user[1]);
				System.out.println("Expiry Date:" +user[2]);
			}
		}
	
		
	}

