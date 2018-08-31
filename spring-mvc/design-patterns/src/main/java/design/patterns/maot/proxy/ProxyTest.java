package design.patterns.maot.proxy;

public class ProxyTest {

    public static void main(String[] args) throws Exception{
        DynamicProxy demoProxy = new DynamicProxy(new Boy());
        Person person = (Person) demoProxy.createProxy();
        person.eat();

        DynamicProxy demoProxy2 = new DynamicProxy(new Man());
        Person person2 = (Person) demoProxy2.createProxy();
        person2.eat();

        StaticProxy staticProxy = new StaticProxy(new Boy());
        staticProxy.eat();


    }
}
