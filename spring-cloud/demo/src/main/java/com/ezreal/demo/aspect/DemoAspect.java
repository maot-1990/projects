package com.ezreal.demo.aspect;

import com.ezreal.demo.anno.SpelDemo;
import com.ezreal.demo.configuration.DemoProperties;
import com.ezreal.demo.dto.Persion;
import com.ezreal.demo.functioninterface.Consumer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by tao.mao on 2020/4/19.
 */
@Aspect
@Component
public class DemoAspect implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Pointcut(value = "execution(* com.ezreal.demo.service.DemoService.aspectj(..))")
    public void pointCut() {

    }

    // @Around(value = "pointCut()")
    @Around(value = "execution(* com.ezreal.demo.service.DemoService.aspectj(..)) || @annotation(com.ezreal.demo.anno.SpelDemo)")
    public void around(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Object[] obj = point.getArgs();
        SpelDemo spelDemo = method.getAnnotation(SpelDemo.class);
        if (spelDemo != null) {
            parseSpel(spelDemo, method, obj);
        }
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

    private void parseSpel(SpelDemo spelDemo, Method method, Object[] obj) {
        String spelKey = spelDemo.spelKey();

        EvaluationContext context = new StandardEvaluationContext();
        LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] params = discoverer.getParameterNames(method);
        for (int i = 0; i < obj.length; i++) {
            context.setVariable(params[i], obj[i]);
        }
        DemoProperties demoProperties = applicationContext.getBean(DemoProperties.class);
        Object sysObj = applicationContext.getBean("systemProperties");
        Object persion = applicationContext.getBean(Persion.class);
        context.setVariable("systemProperties", sysObj);
        context.setVariable("persion", persion);

        context.setVariable("demoProperties", demoProperties);
        ((StandardEvaluationContext) context).setBeanResolver(new BeanFactoryResolver(applicationContext));
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(spelKey);
        String spelKeyValue = expression.getValue(context, String.class);
        System.out.println("解析spelKey值为：" + spelKeyValue);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
