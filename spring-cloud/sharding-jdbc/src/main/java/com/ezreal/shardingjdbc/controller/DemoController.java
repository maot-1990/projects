/*
 * Copyright 2018 PHOENIXFIN PTE. LTD.
 */

package com.ezreal.shardingjdbc.controller;

import com.ezreal.shardingjdbc.entity.Test;
import com.ezreal.shardingjdbc.repository.TestRepository;
import com.ezreal.shardingjdbc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tao.mao on 2018/9/1.
 */
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;
    @Autowired
    private DataSourceTransactionManager transactionManager;

    //@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    @GetMapping("/save")
    public Test save(int id, String orderId){
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);

        Test test = null;
        try {
            test = new Test();
            test.setId(id);
            test.setName("maot");
            test.setOrderId(orderId);
            demoService.insert(test);

            Test test2 = new Test();
            test2.setId(id + 1);
            test2.setName("maot");
            test2.setOrderId(orderId);
            demoService.insert(test2);
            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
        }
        return test;
    }

    @GetMapping("/delete")
    public int delete(Integer id, String orderId){
        return demoService.delete(id, orderId);
    }

    @GetMapping("/select")
    public List<Test> select(){
        return demoService.select();
    }

    public static void main(String[] args) {
        String i = "1";
        System.out.println(i.hashCode());
    }
}
