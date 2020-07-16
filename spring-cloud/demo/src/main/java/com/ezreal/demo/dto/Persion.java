package com.ezreal.demo.dto;

import lombok.Data;

/**
 * Created by tao.mao on 2020/4/17.
 */
@Data
public class Persion {

    private String id;

    private String name;

    public Persion() {
    }

    public Persion(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
