package com.pers.blog.system.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pers.blog.bean.SystemInfo;
import com.pers.blog.system.dao.SystemInfoDao;
import com.pers.blog.system.service.SystemInfoService;

@Service("systemInfoService")
public class SystemInfoServiceImpl implements SystemInfoService{

	@Resource
	private SystemInfoDao systemInfoDao;

	@Override
	public SystemInfo getSystemInfo() {
		return systemInfoDao.selectByPrimaryKey("66666666666666668888888888888888");
	}

	@Override
	public void updateSystemInfoVisitTimes(String ip, String times, String id) {
		systemInfoDao.updateSystemInfoVisitTimes(ip, times, id);
		
	}
	
}
