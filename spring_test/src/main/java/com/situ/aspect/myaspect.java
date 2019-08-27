package com.situ.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class myaspect {
	
	public void aa(JoinPoint p) throws Throwable{
		 System.out.println(p.getTarget().getClass().getName());
			System.out.println("前置.......");
		} 
	 public void bb(JoinPoint p,Object result) throws Throwable{
			System.out.println("返回.......");
		} 
	 public void cc(JoinPoint p) throws Throwable{
			System.out.println("后置.......");
		} 
	 public void dd(ProceedingJoinPoint pjp) throws Throwable{
			System.out.println("h前置.......");
			pjp.proceed();
			System.out.println("h后置.......");
		} 
	 public void ee( JoinPoint jp, Throwable e) throws Throwable{
			System.out.println("出错了"+e.getMessage());
		}

}
