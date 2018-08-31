package com.pers.blog.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pers.blog.bean.SystUser;

public interface SystUserDao {
    int insert(SystUser record);

    public List<SystUser> getSystUserRecent();
    
    public SystUser selectSystUserByNameAndPwd(@Param("userName") String userName,@Param("pwd") String pwd);

    public SystUser selectSystUserByQQOpenId(String qqOpenid);
    
    public void updateSystUserByQQOpenId(SystUser user);

}