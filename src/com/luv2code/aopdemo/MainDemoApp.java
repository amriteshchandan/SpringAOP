package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class MainDemoApp {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		accountDAO.addAccount(new Account(), true, 1);
		accountDAO.doWork();
		accountDAO.setName("amritesh");
		accountDAO.setServiceCode("007");
		accountDAO.getName();
		accountDAO.getServiceCode();
	
		
		context.close();
	}
	
}
