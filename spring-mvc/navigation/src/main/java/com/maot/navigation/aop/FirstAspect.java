package com.maot.navigation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 实现aop，spring必须使用代理模式，代理模式必须定义接口
 * @author maot
 *
 */
@Component
@Aspect
public class FirstAspect {

	@Around(value="handle()")
	public Object around(ProceedingJoinPoint point){
		System.out.println("around_before");
		Object key = null;
		//获取传入目标方法的参数
        Object[] args = point.getArgs();
        for(int i=0; i<args.length; i++){
        	System.out.println(args[i]);
        }
        try {
        	if(point.getSignature().getName().equals("testAspect")){
        		point.proceed(new Object[]{"mao","tao"}); //传入切点新的参数
        	}else if(point.getSignature().getName().equals("testAspect2")){
        		point.proceed(new Object[]{"mao","tao","key"});
        	}
        	//point.proceed();
			//
		} catch (Throwable e) {
			e.printStackTrace();
		}
        System.out.println("around_after");
		return key;
	}
	
	@Pointcut("execution(* com.maot.navigation.demo.service..*.*(..))")
	public void handle(){
		
	}
	
	@Before(value="handle()")
	public void before(JoinPoint point){
		System.out.println("before:" + point.getSignature().getName());
		System.out.println("before:" + point.getArgs().length);
	}
	
	@After(value="handle()")
	public void after(JoinPoint point){
		System.out.println("after:" + point.getSignature().getName());
		System.out.println("after:" + point.getArgs().length);
	}
	
}
