package com.cn.aop.demo2;

import java.lang.annotation.Annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class MyAop {
	
	private static final Logger logger = LoggerFactory.getLogger(MyAop.class);
	
	/**
	 * 声明切面的切入点
	 */
	@Pointcut("execution(* com.cn.aop.demo2.*.*(..))")
	public void cook(){};
	
	@Before("cook()")
	public void buyFood(JoinPoint joinPoint){
		if(hasAnnotationMethod(joinPoint,CardNeed.class) != null){
			getCard();
		}
		System.out.println("早起去买食物");
	}
	
	@After("cook()")
	public void cookFood(JoinPoint joinPoint) throws ClassNotFoundException{
		System.out.println("给工作的工人烧食物");
		/*String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		System.out.println(targetName);
		System.out.println(methodName);
		Method[] methods = joinPoint.getTarget().getClass().getMethods();
		String operationType = "";
		String operationName = "";
		for (Method method : methods) {
			if(method.getName().equals(methodName)){
				System.out.println(method.getName());
				Log log = method.getAnnotation(Log.class);
				if(log!=null){
					operationType = log.operationType();
					operationName = log.operationName();
					break;
				}
			}
		}
		System.out.println(operationType + ";" + operationName);*/
		
		if(hasAnnotationMethod(joinPoint,Log.class) != null){
			Log log = (Log) hasAnnotationMethod(joinPoint,Log.class);
			String operationType = log.operationType();
			String operationName = log.operationName();
			logger.info(operationType + ";" + operationName);
		}
	}
	
	public Annotation hasAnnotationMethod(JoinPoint joinPoint, Class clazz){
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Annotation a =  methodSignature.getMethod().getAnnotation(clazz);
		return a;
	}
	
	@Around("cook()")
	public void water(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("工作之前给人员递水");
		pjp.proceed();
		System.out.println("工作之后给工作人员滴水");
	}
	
	public Card getCard(){
		//这里可以从shiro或者缓存中去取值
		//本方法演示从作用域中取值
		RequestAttributes requestAttributes =  RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)requestAttributes;
		return null;
	}
	
}
