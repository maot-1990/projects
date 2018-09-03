/*
 * Copyright 2018 PHOENIXFIN PTE. LTD.
 */

package com.ezreal.shardingjdbc.repository;

import com.ezreal.shardingjdbc.entity.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tao.mao on 2018/9/1.
 */
@Mapper
public interface TestRepository {

    int insert(Test test);

    List<Test> select();

    int delete(@Param("id") Integer id, @Param("orderId") String orderId);
}
