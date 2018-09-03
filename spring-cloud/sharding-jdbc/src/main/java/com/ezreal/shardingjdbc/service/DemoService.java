/*
 * Copyright 2018 PHOENIXFIN PTE. LTD.
 */

package com.ezreal.shardingjdbc.service;

import com.ezreal.shardingjdbc.entity.Test;

import java.util.List;

/**
 * Created by tao.mao on 2018/9/1.
 */
public interface DemoService {

    int insert(Test test);

    List<Test> select();

    int delete(Integer id, String orderId);
}
