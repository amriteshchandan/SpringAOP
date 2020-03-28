package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component("accountDAO")
public class AccountDAO {

	public void addAccount() {
		System.out.println(this.getClass() + "Doing My DB Work Here.");
	}
	
}
