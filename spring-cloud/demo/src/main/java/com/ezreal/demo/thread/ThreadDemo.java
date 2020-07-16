package com.ezreal.demo.thread;

/**
 * Created by tao.mao on 2020/5/28.
 */
public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                do {
                    i++;
                    System.out.println("i=" + i);
                } while (i < 10);
            }
        });
        thread.start();
        thread.join();



        System.out.println("main");
    }


}
