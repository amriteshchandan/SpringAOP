package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(value = 1)
public class MyCloudLogAspect {

	@Before(value = "com.luv2code.aopdemo.aspect.AOPAspectsPointCutExpression.forDAOPackageNoGettersAndSetters()")
	public void performLoggingToCloudAdvice() {
		System.out.println("[MyDemoLoggingAspect] performLoggingToCloudAdvice()");
	}
	
}
