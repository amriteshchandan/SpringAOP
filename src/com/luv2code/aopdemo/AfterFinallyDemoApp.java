package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		List<Account> accounts = null;
		
		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = false;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("Exception in main program :: " + e);
		}
		
		
		System.out.println("Accounts :: " + accounts);
		
		context.close();
	}
	
}
