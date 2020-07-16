package com.ezreal.demo.functioninterface;

/**
 * Created by tao.mao on 2020/6/16.
 */
public class ConsumerImpl implements Consumer {

    @Override
    public String accept(String s, String b) {
        System.out.println("accept");
        return s + b;
    }
}
