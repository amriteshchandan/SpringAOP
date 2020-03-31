package com.luv2code.aopdemo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);
		
		System.out.println("Calling getFortune()");
		String data = trafficFortuneService.getFortune();
		System.out.println("Fortune is :: "+ data);
		System.out.println("Finished");
		
		
//		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
//		List<Account> accounts = null;
//		
//		try {
//			// add a boolean flag to simulate exceptions
//			boolean tripWire = false;
//			accounts = accountDAO.findAccounts(tripWire);
//		} catch (Exception e) {
//			System.out.println("Exception in main program :: " + e);
//		}
//		
//		
//		System.out.println("Accounts :: " + accounts);
		
		context.close();
	}
	
}
