package com.cg.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestAOP {
	
	Logger logger=LoggerFactory.getLogger(RestAOP.class);
	
	@Before("PointCut()")  // here we not using String because get method return different types
	public void loggingAdvise(JoinPoint joinpoint)
	{
		System.out.println("client is using our services .....");
		logger.info("client is using our services .....");
	}
	
	
	@Pointcut("within( com.cg.services.*)")     // it will apply for all the method of Circle
	public void PointCut()
	{
		
		
	}
	
	@Before("PointCut2()")  
	public void beforeAdvice() {  
	
		System.out.println("A new Buyer is added ...");
		logger.info("A new Buyer is added ...");
		
	
	}  
	
	@Pointcut("execution(public * addBuyer(..))")     // it will apply for all the method of Circle
	public void PointCut2()
	{
		
		
	}
	
	
	
}