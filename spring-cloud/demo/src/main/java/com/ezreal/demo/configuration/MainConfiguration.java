package com.ezreal.demo.configuration;

import com.ezreal.demo.dto.Car;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by tao.mao on 2020/4/19.
 */
@Configuration
@ComponentScan(basePackages = {"com.ezreal.demo"})
@EnableConfigurationProperties(value = DemoConfig.class)
@PropertySource(value = "classpath:/application.properties")
public class MainConfiguration {

    @Bean
    public Car car(DemoConfig demoConfig) {
        return new Car(demoConfig.getId(), demoConfig.getName());
    }

}
