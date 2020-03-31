package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component("trafficFortuneService")
public class TrafficFortuneService {

	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Bad Traffic";
	}

	public String getFortune(boolean tripWire) {
		
		if (tripWire)
			throw new RuntimeException("Major Accident !! - Lockdown!!!");
		return this.getFortune();
		
	}
	
}
