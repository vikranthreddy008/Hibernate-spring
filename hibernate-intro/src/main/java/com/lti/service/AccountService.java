package com.lti.service;

import java.time.LocalDateTime;
import java.util.List;

import com.lti.dao.AccountDao;
import com.lti.dao.GenericDao;
import com.lti.entity.Account;
import com.lti.entity.Transaction;

//classes which contain business logic
//are commonly referred to as service classes

public class AccountService {
	
	public void openAccount(Account acc) {
		GenericDao dao=new GenericDao();
	
		dao.save(acc);
		
	}
	public void withdraw(int acno, double amount, double balance) {
		GenericDao dao=new GenericDao();
	    Account acc=dao.fetchById(Account.class, acno);
	
	 if(amount>acc.getBalance())
		{
			System.out.println("Insufficient balance");
			
		}
		else
		{
			Transaction tx=new Transaction();
			tx.setType("WITHDRAW");
			tx.setDateAndTime(LocalDateTime.now());
			tx.setAmount(amount);
			tx.setAccount(acc);
		    dao.save(tx);
			acc.setBalance(acc.getBalance()-amount);
            dao.save(acc);		
			}
		}

	public void deposit(int acno, double amount) {
		
		GenericDao dao=new GenericDao();
	    Account acc=dao.fetchById(Account.class, acno);
			Transaction tx=new Transaction();
			tx.setType("DEPOSIT");
			tx.setDateAndTime(LocalDateTime.now());
			tx.setAmount(amount);
			tx.setAccount(acc);
		    dao.save(tx);
			acc.setBalance(acc.getBalance()+amount);
            dao.save(acc);		
			
		}
		
	public void transfer(int fromAcno, int toAcno, double amount) {
		GenericDao dao=new GenericDao();
		 Account fromAcc=dao.fetchById(Account.class,fromAcno);
		 Account toAcc=dao.fetchById(Account.class, toAcno);
		 
		 fromAcc.setBalance(fromAcc.getBalance()-amount);
		 toAcc.setBalance(toAcc.getBalance()+amount);
		 dao.save(fromAcc);
		 dao.save(toAcc);

           Transaction tx1=new Transaction();
			tx1.setType("MONEY TRANSFERED");
			tx1.setDateAndTime(LocalDateTime.now());
			tx1.setAmount(amount);
			tx1.setAccount(fromAcc);
		    dao.save(tx1);
			fromAcc.setBalance(fromAcc.getBalance()+amount);
            dao.save(fromAcc);		
         
           Transaction tx2=new Transaction();
			tx2.setType("MONEY RECEIVED");
			tx2.setDateAndTime(LocalDateTime.now());
			tx2.setAmount(amount);
			tx2.setAccount(toAcc);
		    dao.save(tx2);
			toAcc.setBalance(toAcc.getBalance()+amount);
         dao.save(toAcc);		
			
	}
	public double balanceCheck(int acno) {
		GenericDao dao=new GenericDao();
	    Account acc=dao.fetchById(Account.class, acno);
			System.out.println("Balance is:"+acc.getBalance());
			
		return 0;
		
	}
	public List<Transaction>miniStatement(int acno)  {
		AccountDao dao=new AccountDao();
		List<Transaction> list=dao.fetchMiniStatement(acno);
	
		return list;
	}
	

}
		
	