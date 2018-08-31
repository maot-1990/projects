package com.maot.navigation.dao;

import java.util.List;

import com.maot.navigation.entity.WebsiteType;

public interface WebsiteTypeDao {
    int deleteByPrimaryKey(String id);

    int insert(WebsiteType record);

    int insertSelective(WebsiteType record);

    WebsiteType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WebsiteType record);

    int updateByPrimaryKey(WebsiteType record);
    
    public List<WebsiteType> getByPType(String type);
}