package com.maot.navigation.dao;

import java.util.List;

import com.maot.navigation.entity.WebsiteInfo;

public interface WebsiteInfoDao {
    int deleteByPrimaryKey(String id);

    int insert(WebsiteInfo record);

    int insertSelective(WebsiteInfo record);

    WebsiteInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WebsiteInfo record);

    int updateByPrimaryKey(WebsiteInfo record);
    
    public List<WebsiteInfo> getListByType(String type);
    
    public List<WebsiteInfo> getHotWeisite();
}