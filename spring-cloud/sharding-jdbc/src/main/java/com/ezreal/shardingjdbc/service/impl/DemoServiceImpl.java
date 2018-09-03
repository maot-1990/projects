/*
 * Copyright 2018 PHOENIXFIN PTE. LTD.
 */

package com.ezreal.shardingjdbc.service.impl;

import com.ezreal.shardingjdbc.entity.Test;
import com.ezreal.shardingjdbc.repository.TestRepository;
import com.ezreal.shardingjdbc.service.DemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tao.mao on 2018/9/1.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    private TestRepository testRepository;

    @Override
    public int insert(Test test) {
        return testRepository.insert(test);
    }

    @Override
    public List<Test> select() {
        return testRepository.select();
    }

    @Override
    public int delete(Integer id, String orderId) {
        return testRepository.delete(id, orderId);
    }
}
