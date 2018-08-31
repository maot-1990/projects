package com.pers.blog.system.service;

import com.pers.blog.bean.SystUserLog;

public interface SystUserLogService {
	
	public void saveSystUserLog(SystUserLog userLog);
	
	public int getSystUserLogCountByIp(String ip);
}
