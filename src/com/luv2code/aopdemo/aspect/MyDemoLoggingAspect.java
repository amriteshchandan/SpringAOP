package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our advices for logging
	
	@Before(value = "execution(void add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("[MyDemoLoggingAspect] beforeAddAccountAdvice");
	}
	
}
