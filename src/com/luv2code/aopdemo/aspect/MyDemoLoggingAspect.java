package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
		String method = joinPoint.getSignature().toShortString();
		System.out.println("Executing @AfterReturning on :: " + method);
		System.out.println("Returned Data :: " + result);
	}
	
}
