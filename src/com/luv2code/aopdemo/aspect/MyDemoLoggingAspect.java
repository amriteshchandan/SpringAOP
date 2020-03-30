package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

	@Before(value = "com.luv2code.aopdemo.aspect.AOPAspectsPointCutExpression.forDAOPackageNoGettersAndSetters()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("[MyDemoLoggingAspect] beforeAddAccountAdvice()");
		
		// Display method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("methodSignature :: " + methodSignature);
		
		// Display method arguments
		Object[] args = joinPoint.getArgs();
		
		for (Object tempArg : args) {
			System.out.println("Arg :: " + tempArg);
			if (tempArg instanceof Account) {
				Account account = (Account) tempArg;
				System.out.println("account name :: " + account.getName());
				System.out.println("account level :: " + account.getLevel());
			}
		}
	}
	
	@AfterReturning(
			value = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result"
			)
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		
		System.out.println("[MyDemoLoggingAspect] afterReturningFindAccountsAdvice()");
		String method = joinPoint.getSignature().toShortString();
		System.out.println("Executing @AfterReturning on :: " + method);
		System.out.println("Returned Data :: " + result);
		if (result.size() > 0) {
			convertNameToUppercase(result);
		}
		System.out.println("Modified Returned Data :: " + result);
		
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
	
		System.out.println("[MyDemoLoggingAspect] afterThrowingFindAccountsAdvice()");
		System.out.println("Executing @@AfterThrowing for method :: " + joinPoint.getSignature().toShortString());
		System.out.println("Exception :: " + exception);
		
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvise(JoinPoint joinPoint) {
		System.out.println("[MyDemoLoggingAspect] afterFinallyFindAccountsAdvise()");
		System.out.println("Executing @@AfterThrowing for method :: " + joinPoint.getSignature().toShortString());
	}
	
}
