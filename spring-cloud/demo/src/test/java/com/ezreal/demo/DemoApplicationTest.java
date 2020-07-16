package com.ezreal.demo;

import com.ezreal.demo.aspect.DemoAspect;
import com.ezreal.demo.configuration.DemoProperties;
import com.ezreal.demo.configuration.MainConfiguration;
import com.ezreal.demo.dto.Car;
import com.ezreal.demo.functioninterface.Consumer;
import com.ezreal.demo.functioninterface.ConsumerImpl;
import com.ezreal.demo.service.DemoService;
import com.ezreal.demo.service.impl.DemoServiceImpl;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Proxy;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class DemoApplicationTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfiguration.class);
        Object demoConfig = applicationContext.getBean(DemoProperties.class);
        System.out.println(demoConfig.toString());

        Car car = applicationContext.getBean(Car.class);
        System.out.println(car.toString());

        DemoService demoService = applicationContext.getBean(DemoService.class);
        // demoService.aspectj(car);
        demoService.aspectjSpel(car);

    }


    @Test
    public void test02() {
        LocalDateTime local = LocalDateTime.now();
        LocalDateTime ago = LocalDateTime.of(2019,5,1, 0,0,0);

        long now = local.toEpochSecond(ZoneOffset.ofHours(8));
        long agoL = ago.toEpochSecond(ZoneOffset.ofHours(8));

        System.out.println((now - agoL) / (24 * 60 * 60));

        List<String> list = new ArrayList<>();
    }

    @Test
    public void test03() throws Exception {

        String str = "兮ABCD哈";
        byte[] bytes = str.getBytes("utf-8");
        System.out.println(new String(bytes, "utf-8"));
    }

    @Test
    public void test04() throws Exception {

        // Consumer consumer = (s, b) -> System.out.println(s + b);
        /// consumer.accept("a", "b");

        //test((a, b) -> System.out.println(a + "&" + b), "s", "b");

    }

    private void test(Consumer consumer, String s, String b) {
        consumer.accept(s, b);
    }

    @Test
    public void test05() throws Exception {

        String str = "asdfhweuqfjasdf";
        int key = 123456;

        char[] cStr = str.toCharArray();
        for (int i = 0; i < cStr.length; i++) {
            cStr[i] = (char) (cStr[i] ^ key);
        }

        for (int i = 0; i < cStr.length; i++) {
            cStr[i] = (char) (cStr[i] ^ key);
        }

        System.out.println(cStr);

    }

    @Test
    public void test5() {

        Consumer consumer = new ConsumerImpl();
        Consumer obj = (Consumer) Proxy.newProxyInstance(consumer.getClass().getClassLoader(), consumer.getClass().getInterfaces(),
                (a, b, c) -> {
                    System.out.println("before");

                    System.out.println("after");
                    return b.invoke(consumer, c);
                });

        System.out.println(obj.accept("a", "b"));

    }

    @Test
    public void test6() {
        String s = "wefu;ahs,fla,wef;asd,gads,gw";
        StringTokenizer tokenizer = new StringTokenizer(s, ",;");
        while (tokenizer.hasMoreElements()) {
            System.out.println(tokenizer.nextElement());
        }

        StringJoiner joiner = new StringJoiner(",");
        joiner.add("abc");
        joiner.add("cbd");
        System.out.println(joiner.toString());
    }

    @Test
    public void test7() throws Exception{
        String s = "ABCD\nbad";
        byte[] bytes = s.getBytes();
        ByteArrayInputStream bis = new ByteArrayInputStream(s.getBytes());
        InputStreamReader isr = new InputStreamReader(bis);
        BufferedReader br = new BufferedReader(isr);
        /*int a = 0;
        System.out.println(bis.read());
        System.out.println(bis.read());
        bis.mark(1);
        System.out.println(bis.read());
        System.out.println(bis.read());

        System.out.println(bis.read());
        bis.reset();
        System.out.println(bis.read());
        System.out.println(bis.read());*/

        /*char[] chars = new char[4];
        System.out.println(isr.read(chars));
        System.out.println(chars);*/

        System.out.println(br.readLine());
        System.out.println(br.readLine());

    }

    @Test
    public void test07() throws Exception {
        FileInputStream fis = new FileInputStream("/Users/ezreal/Desktop/hehe.txt");
        /*byte[] bytes = new byte[2048];
        fis.read(bytes);
        System.out.println(bytes);
        System.out.println(new java.lang.String(bytes, "UTF-8"));*/
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());

        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return null;
            }
        };

    }
}

