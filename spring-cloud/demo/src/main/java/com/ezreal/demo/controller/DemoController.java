package com.ezreal.demo.controller;

import com.ezreal.demoa.config.DemoConfig;
import com.ezreal.demoa.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
// 加上该配置，远程配置信息才会动态刷新，有@Configuration注解，自动刷新
@RefreshScope
public class DemoController {

    @Value("${dev.test.name}")
    private String name;
    @Value("${dev.test.version}")
    private String version;
    @Autowired
    private DemoConfig demoConfig;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DemoService demoService;

    @GetMapping("/demo/test")
    public String test() {
        demoService.test();
        return "name=" + name + ",version=" + version;
    }

    @GetMapping("/demo/test2")
    public String test2() {

        String html = restTemplate.getForObject("https://blog.csdn.net/kobejayandy/article/details/17855513", String.class);
        System.out.println(html);
        return html;
    }
}
