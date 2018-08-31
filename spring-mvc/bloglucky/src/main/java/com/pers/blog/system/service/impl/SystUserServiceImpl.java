package com.pers.blog.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pers.blog.bean.SystUser;
import com.pers.blog.system.dao.SystUserDao;
import com.pers.blog.system.service.SystUserService;

@Service
public class SystUserServiceImpl implements SystUserService{

	@Resource
	private SystUserDao systUserDao;
	
	/**
	 * 获取最近的50个用户
	 */
	public List<SystUser> getSystUserRecent() {
		
		return systUserDao.getSystUserRecent();
	}

	public void saveSystUser(SystUser user) {
		systUserDao.insert(user);
		
	}

	public SystUser selectSystUserByNameAndPwd(String userName, String pwd) {
		
		return systUserDao.selectSystUserByNameAndPwd(userName, pwd);
	}

	@Override
	public SystUser selectSystUserByQQOpenId(String qqOpenid) {
		return systUserDao.selectSystUserByQQOpenId(qqOpenid);
	}

	@Override
	public void updateSystUserByQQOpenId(SystUser user) {
		systUserDao.updateSystUserByQQOpenId(user);
	}
	
}
