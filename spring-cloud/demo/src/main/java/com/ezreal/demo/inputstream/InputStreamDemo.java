package com.ezreal.demo.inputstream;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by tao.mao on 2020/5/28.
 */
public class InputStreamDemo {

    public static void main(String[] args) throws Exception{
        byte[] bytes = new byte[]{'a', 'B', 'c', 'D'};
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        int b = 0;
        byte[] buffer = new byte[4];
        int j = 0;
        while(( b = inputStream.read(buffer)) > 0) {
            System.out.println(b);
            System.out.println((char) b);


        }

        System.out.println(new String(buffer));
        //System.out.println(Arrays.asList(buffer));
    }


}
