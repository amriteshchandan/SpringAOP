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
		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);
		logger.info("Fortune is :: "+ data);
		logger.info("Finished");
		
		context.close();
	}
	
}
