package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class MainDemoApp {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		Account account = new Account();
		account.setName("SBI");
		account.setLevel("Txn Account");
		System.out.println("\nCalling addAccount()");
		accountDAO.addAccount(account, true, 1);
		System.out.println("\nCalling doWork()");
		accountDAO.doWork();
		accountDAO.setName("amritesh");
		accountDAO.setServiceCode("007");
		accountDAO.getName();
		accountDAO.getServiceCode();
	
		
		context.close();
	}
	
}
