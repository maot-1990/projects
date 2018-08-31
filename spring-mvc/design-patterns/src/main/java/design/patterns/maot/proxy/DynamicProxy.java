package design.patterns.maot.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(Object obj){
        this.target = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理前");
        method.invoke(target, args);
        System.out.println("动态代理后");
        return null;
    }

    public Object createProxy(){

        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(),
                this);
    }
}
