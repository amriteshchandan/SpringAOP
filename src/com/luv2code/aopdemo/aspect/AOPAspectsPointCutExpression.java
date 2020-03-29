package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AOPAspectsPointCutExpression {

	@Pointcut(value = "execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDAOPackage() {}
	
	@Pointcut(value = "execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getters() {}
	
	@Pointcut(value = "execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setters() {}
	
	@Pointcut(value = "forDAOPackage() && !(getters() || setters())")
	public void forDAOPackageNoGettersAndSetters() {}
	
}
