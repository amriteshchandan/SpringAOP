package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component("accountDAO")
public class AccountDAO {

	public void addAccount(Account account) {
		System.out.println(this.getClass() + "Doing My DB Work Here.");
	}
	
}
