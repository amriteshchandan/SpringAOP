package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our advices for logging
	@Pointcut(value = "execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	
	@Before("forDAOPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("[MyDemoLoggingAspect] beforeAddAccountAdvice");
	}
	
}
