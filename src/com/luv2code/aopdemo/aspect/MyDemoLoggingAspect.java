package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our advises for logging
	@Pointcut(value = "execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut(value = "execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void getters() {}
	
	@Pointcut(value = "execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void setters() {}
	
	@Pointcut(value = "forDAOPackage() && !(getters() || setters())")
	private void forDAOPackageNoGettersAndSetters() {}
	
	@Before(value = "forDAOPackageNoGettersAndSetters()")
	public void beforeAddAccountAdvice() {
		System.out.println("[MyDemoLoggingAspect] beforeAddAccountAdvice");
	}
	
	@Before(value = "forDAOPackageNoGettersAndSetters()")
	public void performAPIAnalyticsAdvice() {
		System.out.println("[MyDemoLoggingAspect] performAPIAnalyticsAdvice");
	}
	
}
