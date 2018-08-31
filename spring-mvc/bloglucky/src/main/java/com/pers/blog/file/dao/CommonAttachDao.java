package com.pers.blog.file.dao;

import com.pers.blog.bean.CommonAttach;


public interface CommonAttachDao {
    int deleteByPrimaryKey(String id);

    int insert(CommonAttach record);

    int insertSelective(CommonAttach record);

    CommonAttach selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CommonAttach record);

    int updateByPrimaryKey(CommonAttach record);
}