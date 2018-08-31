package com.maot.navigation.dao;

import java.util.List;

import com.maot.navigation.entity.UserWebsiteInfo;


public interface UserWebsiteInfoDao {
    int deleteByPrimaryKey(String id);

    int insert(UserWebsiteInfo record);

    int insertSelective(UserWebsiteInfo record);

    UserWebsiteInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserWebsiteInfo record);

    int updateByPrimaryKey(UserWebsiteInfo record);
    
    public List<UserWebsiteInfo> getUserWebsiteInfo(String userId) throws Exception;
}