package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		accountDAO.addAccount();
		accountDAO.addAccount();
		accountDAO.addAccount();
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		membershipDAO.addAccount();
		membershipDAO.addAccount();
		membershipDAO.addAccount();
		context.close();
	}
	
}