package com.ezreal.demo.functioninterface;

/**
 * Created by tao.mao on 2020/6/2.
 */
@FunctionalInterface
public interface Consumer {

    String accept(String s, String b);

    default String accept(String s) {
        System.out.println(s);
        return s;
    }
}
