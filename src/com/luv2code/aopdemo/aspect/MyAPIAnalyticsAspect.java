package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAPIAnalyticsAspect {

	@Before(value = "com.luv2code.aopdemo.aspect.AOPAspectsPointCutExpression.forDAOPackageNoGettersAndSetters()")
	public void performAPIAnalyticsAdvice() {
		System.out.println("[MyDemoLoggingAspect] performAPIAnalyticsAdvice()");
	}
	
}
