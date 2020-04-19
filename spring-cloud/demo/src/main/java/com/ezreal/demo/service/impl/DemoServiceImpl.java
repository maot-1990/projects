package com.ezreal.demo.service.impl;

import com.ezreal.demo.dto.Car;
import com.ezreal.demo.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * Created by tao.mao on 2018/8/25.
 */
@Service
public class DemoServiceImpl implements DemoService {


    @Override
    public void test() {

    }

    @Override
    public void aspectj(Car car) {
        System.out.println("执行aspectj方法");
    }


}
