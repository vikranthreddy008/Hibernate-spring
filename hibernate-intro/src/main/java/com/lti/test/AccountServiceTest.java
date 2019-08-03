package com.lti.test;

import java.util.List;

import org.junit.Test;

import com.lti.entity.Account;
import com.lti.entity.Transaction;
import com.lti.service.AccountService;

public class AccountServiceTest {
	@Test
	public void openAccount() {
		
		AccountService service=new AccountService();
		Account account=new Account();
		account.setName("Naveen");
		account.setBalance(20000);
		account.setType("saving");
		service.openAccount(account);
}
	
	@Test
	public void withdraw() {
		AccountService service=new AccountService();
	service.withdraw(221, 10000,20000);
	
	}
	@Test
public void deposit() {
		AccountService service=new AccountService();
		service.deposit(221, 25000);
	}
	@Test
	public void checkbalance() {
		AccountService service=new AccountService();
		service.balanceCheck(221);
	}
	
	@Test
	public void transfer() {
		AccountService service=new AccountService();
	service.transfer(221, 222,10000);
	}
	@Test
	public void miniStatement() {
		AccountService service=new AccountService();
		List<Transaction> transactions=service.miniStatement(221);
		for(Transaction t: transactions)
		{
			System.out.println(t.getAmount());
       System.out.println(t.getType());
		System.out.println(t.getDateAndTime());
		
		}
		
		
		
	}
}
