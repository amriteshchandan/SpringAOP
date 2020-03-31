package com.luv2code.aopdemo;


import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {
	
	private static Logger logger = Logger.getLogger(AroundDemoApp.class.getName());
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);
		
		logger.info("Calling getFortune()");
		String data = trafficFortuneService.getFortune();
		logger.info("Fortune is :: "+ data);
		logger.info("Finished");
		
		
//		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
//		List<Account> accounts = null;
//		
//		try {
//			// add a boolean flag to simulate exceptions
//			boolean tripWire = false;
//			accounts = accountDAO.findAccounts(tripWire);
//		} catch (Exception e) {
//			logger.info("Exception in main program :: " + e);
//		}
//		
//		
//		logger.info("Accounts :: " + accounts);
		
		context.close();
	}
	
}
