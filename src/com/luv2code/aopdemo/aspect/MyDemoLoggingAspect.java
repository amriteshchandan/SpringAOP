package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(value = 2)
public class MyDemoLoggingAspect {

	@Before(value = "com.luv2code.aopdemo.aspect.AOPAspectsPointCutExpression.forDAOPackageNoGettersAndSetters()")
	public void beforeAddAccountAdvice() {
		System.out.println("[MyDemoLoggingAspect] beforeAddAccountAdvice()");
	}
	
}
