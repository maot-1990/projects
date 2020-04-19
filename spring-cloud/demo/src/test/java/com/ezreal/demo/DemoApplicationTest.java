package com.ezreal.demo;

import com.ezreal.demo.configuration.DemoConfig;
import com.ezreal.demo.configuration.MainConfiguration;
import com.ezreal.demo.dto.Car;
import com.ezreal.demo.service.DemoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.security.RunAs;

public class DemoApplicationTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfiguration.class);
        Object demoConfig = applicationContext.getBean(DemoConfig.class);
        System.out.println(demoConfig.toString());

        Car car = applicationContext.getBean(Car.class);
        System.out.println(car.toString());


        DemoService demoService = applicationContext.getBean(DemoService.class);
       demoService.aspectj(car);
    }
}
