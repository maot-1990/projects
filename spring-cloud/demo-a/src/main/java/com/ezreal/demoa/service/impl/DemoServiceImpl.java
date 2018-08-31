package com.ezreal.demoa.service.impl;

import com.ezreal.demoa.da.UserDO;
import com.ezreal.demoa.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tao.mao on 2018/8/25.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    AtomicInteger autoInt = new AtomicInteger(1);

    private Object lock = new Object();

    @Override
    public void test() {
        System.out.println("测试数据库性能");
        int i = 0;
        while (i < 100) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        synchronized (lock) {
                            lock.wait();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String listSql = "select * from user";
                    List result = jdbcTemplate.query(listSql, new RowMapper<UserDO>() {
                        @Override
                        public UserDO mapRow(ResultSet rs, int rowNum) throws SQLException {
                            UserDO user = new UserDO();
                            user.setOid(rs.getString("oid"));
                            return user;
                        }
                    });
                    long startTime = System.currentTimeMillis();
                    String updateSql = "update user set base_fee_rate=base_fee_rate+1 where oid='5969db686732d54312eb960d'";
                    jdbcTemplate.update(updateSql);
                    int i = 2;
                    while (i < 12) {

                        String insterSql = "insert into ip_record(oid,`event`,user_oid,ip) values ('" + autoInt.incrementAndGet() + " ','hello','12345678','123456789')";
                        i++;
                        jdbcTemplate.update(insterSql);
                    }

                    long endTime = System.currentTimeMillis();
                    System.out.println((endTime - startTime) / 1000.00);

                }
            }).start();
            i++;
        }
        synchronized (lock) {
            lock.notifyAll();
        }


    }
}
