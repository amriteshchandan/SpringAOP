package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		List<Account> accounts = accountDAO.findAccounts();
		
		System.out.println("Accounts :: " + accounts);
		
		context.close();
	}
	
}
