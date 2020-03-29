package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component("accountDAO")
public class AccountDAO {
	
	private String name;
	private String serviceCode;

	public void addAccount(Account account, boolean vipFlag, int x) {
		System.out.println("[" + this.getClass() + "] addAccount()");
	}
	
	public void doWork() {
		System.out.println("[" + this.getClass() + "] doWork()");
	}

	public String getName() {
		System.out.println("[" + this.getClass() + "] getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println("[" + this.getClass() + "] setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("[" + this.getClass() + "] getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("[" + this.getClass() + "] setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	public List<Account> findAccounts(boolean tripWire) {
		
		// just simulating an exception
		if (tripWire) {
			throw new RuntimeException("No soup for you !!!");
		}
		List<Account> accounts = new ArrayList<>();
		accounts.add(new Account("Chandan", "Gold"));
		accounts.add(new Account("Jayant", "Silver"));
		accounts.add(new Account("Aman", "Platinum"));
		return accounts;
	}
	
}
