package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component("membershipDAO")
public class MembershipDAO {

	public void addAccount() {
		System.out.println(this.getClass() + "Doing My DB Work Here.");
	}
	
}