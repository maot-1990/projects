package com.ezreal.demo.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "demo.car")
@Data
public class DemoProperties {

    private String id;

    private String name;

    private String color;

    private String type;

}
