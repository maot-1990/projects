package com.ezreal.demo.dto;

import lombok.Data;

/**
 * Created by tao.mao on 2020/4/17.
 */
@Data
public class Car {

    private String id;

    private String name;

    private String color;

    private String type;

    public Car() {
    }

    public Car(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
