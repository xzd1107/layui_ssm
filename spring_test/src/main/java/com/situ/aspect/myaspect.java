package com.situ.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class myaspect {
	
	public void aa(JoinPoint p) throws Throwable{
		 System.out.println(p.getTarget().getClass().getName());
			System.out.println("ǰ��.......");
		} 
	 public void bb(JoinPoint p,Object result) throws Throwable{
			System.out.println("����.......");
		} 
	 public void cc(JoinPoint p) throws Throwable{
			System.out.println("����.......");
		} 
	 public void dd(ProceedingJoinPoint pjp) throws Throwable{
			System.out.println("hǰ��.......");
			pjp.proceed();
			System.out.println("h����.......");
		} 
	 public void ee( JoinPoint jp, Throwable e) throws Throwable{
			System.out.println("������"+e.getMessage());
		}

}
