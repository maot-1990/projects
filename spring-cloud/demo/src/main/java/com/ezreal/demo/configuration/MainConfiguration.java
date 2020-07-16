package com.ezreal.demo.configuration;

import com.ezreal.demo.dto.Car;
import com.ezreal.demo.dto.Persion;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by tao.mao on 2020/4/19.
 */
@Configuration
@ComponentScan(basePackages = {"com.ezreal.demo.aspect", "com.ezreal.demo.service"})
@EnableConfigurationProperties(value = DemoProperties.class)
@PropertySource(value = "classpath:/application.properties")
@EnableAspectJAutoProxy
@Import(AopAutoConfiguration.class)
//@SpringBootApplication

//@SpringBootConfiguration
//@EnableAutoConfiguration
public class MainConfiguration {

    @Bean
    public Car car(DemoProperties demoConfig) {
        return new Car(demoConfig.getId(), demoConfig.getName());
    }

    @Bean
    public Persion persion(DemoProperties demoConfig) {
        return new Persion("1", "zhangsan");
    }

}
