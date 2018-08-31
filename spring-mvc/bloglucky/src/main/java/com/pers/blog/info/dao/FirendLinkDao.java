package com.pers.blog.info.dao;

import java.util.List;

import com.pers.blog.bean.FirendLink;

public interface FirendLinkDao {
    int deleteByPrimaryKey(String id);

    int insert(FirendLink record);

    int insertSelective(FirendLink record);

    FirendLink selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FirendLink record);

    int updateByPrimaryKey(FirendLink record);
    
    public List<FirendLink> getFirendLinkList();
}