package com.pers.blog.system.service;

import com.pers.blog.bean.SystemInfo;

public interface SystemInfoService {

	public SystemInfo getSystemInfo();
	
	/**
	 * 更新访问量
	 * @param ip 访问ip+1
	 * @param times 访问总次数+1
	 */
	public void updateSystemInfoVisitTimes(String ip, String times, String id);
}
