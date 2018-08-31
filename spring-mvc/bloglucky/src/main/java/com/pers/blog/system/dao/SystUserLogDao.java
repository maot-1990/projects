package com.pers.blog.system.dao;

import com.pers.blog.bean.SystUserLog;


public interface SystUserLogDao {
    int deleteByPrimaryKey(String id);

    int insert(SystUserLog record);

    int insertSelective(SystUserLog record);

    SystUserLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SystUserLog record);

    int updateByPrimaryKey(SystUserLog record);
    
    public int getSystUserLogCountByIp(String ip); 
    
}