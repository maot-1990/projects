package com.pers.blog.system.service;

import java.util.List;

import com.pers.blog.bean.SystUser;

public interface SystUserService {
	
	public List<SystUser> getSystUserRecent();
	
	public void saveSystUser(SystUser user);
	
	public SystUser selectSystUserByNameAndPwd(String userName, String pwd);

    public SystUser selectSystUserByQQOpenId(String qqOpenid);
    
    public void updateSystUserByQQOpenId(SystUser user);

}
