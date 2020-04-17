package com.ezreal.demo.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "dev.test")
public class DemoConfig implements InitializingBean {

    private String name;
    private String version;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("name=" + name + ",version=" + version);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
