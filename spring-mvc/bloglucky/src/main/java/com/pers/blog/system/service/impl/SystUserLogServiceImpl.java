package com.pers.blog.system.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pers.blog.bean.SystUserLog;
import com.pers.blog.system.dao.SystUserLogDao;
import com.pers.blog.system.service.SystUserLogService;

@Service("systUserLogService")
public class SystUserLogServiceImpl implements SystUserLogService{
	@Resource
	private SystUserLogDao systUserLogDao;
	
	@Override
	public void saveSystUserLog(SystUserLog userLog) {
		systUserLogDao.insert(userLog);
		
	}

	@Override
	public int getSystUserLogCountByIp(String ip) {
		return systUserLogDao.getSystUserLogCountByIp(ip);
	}

}
