package com.situ.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class myaspect02 {
	
	@Pointcut("execution(public * get*(..))")
	public void anyMethod() {
		
	}
	@Before(value = "anyMethod()")
    public void exe(JoinPoint p) throws Throwable{
		System.out.println("ǰ��.......");
	}
	@After(value = "anyMethod()")
    public void exe1(JoinPoint p) throws Throwable{
		System.out.println("����.......");
	}
	@AfterReturning(value = "anyMethod()",returning="o")
    public void exe2(JoinPoint p,Object o) throws Throwable{
		System.out.println("����1.......");
	}	
	@Around(value = "anyMethod()")
    public void exe34(ProceedingJoinPoint p) throws Throwable{
		System.out.println("hǰ��.......");
		p.proceed();
		System.out.println("h����.......");
	}	
	@AfterThrowing(value = "anyMethod()",throwing="o")
    public void exe2(JoinPoint p,Throwable o) throws Throwable{
		System.out.println("����......."+o.getMessage());
	}

	
}
