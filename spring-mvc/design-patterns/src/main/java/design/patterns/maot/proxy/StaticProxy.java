package design.patterns.maot.proxy;

public class StaticProxy implements Person{

    private Boy boy;

    public StaticProxy(Boy boy){
        this.boy = boy;
    }

    @Override
    public void eat() {
        System.out.println("静态代理前");
        boy.eat();
        System.out.println("静态代理后");
    }
}
