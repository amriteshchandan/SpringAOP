package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(value = 2)
public class MyDemoLoggingAspect {

	private static Logger logger = Logger.getLogger(MyDemoLoggingAspect.class.getName());
	
	@Before(value = "com.luv2code.aopdemo.aspect.AOPAspectsPointCutExpression.forDAOPackageNoGettersAndSetters()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		logger.info("[MyDemoLoggingAspect] beforeAddAccountAdvice()");
		
		// Display method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		logger.info("methodSignature :: " + methodSignature);
		
		// Display method arguments
		Object[] args = joinPoint.getArgs();
		
		for (Object tempArg : args) {
			logger.info("Arg :: " + tempArg);
			if (tempArg instanceof Account) {
				Account account = (Account) tempArg;
				logger.info("account name :: " + account.getName());
				logger.info("account level :: " + account.getLevel());
			}
		}
	}
	
	@AfterReturning(
			value = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result"
			)
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		
		logger.info("[MyDemoLoggingAspect] afterReturningFindAccountsAdvice()");
		String method = joinPoint.getSignature().toShortString();
		logger.info("Executing @AfterReturning on :: " + method);
		logger.info("Returned Data :: " + result);
		if (result.size() > 0) {
			convertNameToUppercase(result);
		}
		logger.info("Modified Returned Data :: " + result);
		
	}

	private void convertNameToUppercase(List<Account> result) {
		
		for (Account account : result) {  
			account.setName(account.getName().toUpperCase());
		}
		
	}
	
	
	@AfterThrowing(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "exception"
			)
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
	
		logger.info("[MyDemoLoggingAspect] afterThrowingFindAccountsAdvice()");
		logger.info("Executing @AfterThrowing for method :: " + joinPoint.getSignature().toShortString());
		logger.info("Exception :: " + exception);
		
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvise(JoinPoint joinPoint) {
		
		logger.info("[MyDemoLoggingAspect] afterFinallyFindAccountsAdvise()");
		logger.info("Executing @After for method :: " + joinPoint.getSignature().toShortString());
		
	}
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		logger.info("[MyDemoLoggingAspect] aroundAspect()");
		logger.info("Executing @Around for method :: " + proceedingJoinPoint.getSignature().toShortString());
		long start = System.currentTimeMillis();
		logger.info("Proceeding to execute the method");
		Object result = null; 
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			logger.warning(e.getMessage());
			result = "Major Accident - But you will be airlifted !!!";
		}
		logger.info("Method executed");
		long end = System.currentTimeMillis();
		long duration = end - start;
		logger.info("Time Taken = " + (duration/1000) + " seconds.");
		return result;
		
	}
	
}
