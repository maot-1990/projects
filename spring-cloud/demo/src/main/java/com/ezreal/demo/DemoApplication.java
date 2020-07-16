package com.ezreal.demo;

import com.ezreal.demo.configuration.DemoProperties;
import com.ezreal.demo.configuration.MainConfiguration;
import com.ezreal.demo.dto.Car;
import com.ezreal.demo.service.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@EnableWebSocket

@Import(MainConfiguration.class)
public class DemoApplication {

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);


        Object demoConfig = applicationContext.getBean(DemoProperties.class);
        System.out.println(demoConfig.toString());

        Car car = applicationContext.getBean(Car.class);
        System.out.println(car.toString());

        DemoService demoService = applicationContext.getBean(DemoService.class);
        // demoService.aspectj(car);
        demoService.aspectjSpel(car);
    }

}
