package com.ezreal.demo;

import com.ezreal.demo.configuration.DemoProperties;
import com.ezreal.demo.configuration.MainConfiguration;
import com.ezreal.demo.dto.Car;
import com.ezreal.demo.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.atomic.AtomicInteger;

public class DemoApplicationTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfiguration.class);
        Object demoConfig = applicationContext.getBean(DemoProperties.class);
        System.out.println(demoConfig.toString());

        Car car = applicationContext.getBean(Car.class);
        System.out.println(car.toString());

        DemoService demoService = applicationContext.getBean(DemoService.class);
        demoService.aspectj(car);

    }
}
