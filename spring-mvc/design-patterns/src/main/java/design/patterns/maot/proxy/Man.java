package design.patterns.maot.proxy;

public class Man implements Person{

    @Override
    public void eat() {
        System.out.println("对于吃不是那么执着了");
    }
}
