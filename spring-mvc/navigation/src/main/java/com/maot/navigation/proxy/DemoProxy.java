package com.maot.navigation.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.InvocationHandler;

/**
 * 动态代理模式
 * @author maot
 *
 */
public class DemoProxy implements InvocationHandler{
	
	//目标类
	private Object target;
	
	public DemoProxy(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object obj, Method method, Object[] objs)
			throws Throwable {
		Object result = null;
		result = method.invoke(target, objs);
		return result;
	}

	
}
