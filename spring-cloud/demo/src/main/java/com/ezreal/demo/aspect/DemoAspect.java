package com.ezreal.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by tao.mao on 2020/4/19.
 */
@Aspect
@Component
public class DemoAspect {

    @Pointcut(value = "execution(* com.ezreal.demo.service.DemoService.aspectj(..))")
    public void pointCut() {

    }

    // @Around(value = "pointCut()")
    @Around(value = "execution(* com.ezreal.demo.service.DemoService.aspectj(..))")
    public void around(ProceedingJoinPoint point) {
        System.out.println("DemoService.aspect的前置拦截");
        System.out.println("参数：" + point.getArgs()[0]);
        System.out.println("方法名：" + point.getSignature().getName());
        try {
            point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("DemoService.aspect的后置拦截");
    }
}
