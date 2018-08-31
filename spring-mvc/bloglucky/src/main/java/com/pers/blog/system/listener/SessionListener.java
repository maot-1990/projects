package com.pers.blog.system.listener;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import com.pers.blog.bean.SystUserLog;
import com.pers.blog.bean.SystemInfo;
import com.pers.blog.system.service.SystUserLogService;
import com.pers.blog.system.service.SystemInfoService;
import com.pers.blog.util.ApplicationContextUtil;
import com.pers.blog.util.IPUtils;
import com.pers.blog.util.UserUtils;
import com.pers.util.uuid.UuidUtil;

public class SessionListener implements HttpSessionListener, ServletRequestListener{
	private Logger log = Logger.getLogger(SessionListener.class);
	public static Map<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();
	public static Map<String, Integer> todayIpMap = new HashMap<String, Integer>();
	
	private HttpServletRequest request = null;
	
	public void sessionCreated(HttpSessionEvent session) {
		sessionMap.put(session.getSession().getId(), session.getSession());
		log.info("session创建");
		SystemInfoService systemInfoService = (SystemInfoService) ApplicationContextUtil.getBean("systemInfoService");
		SystUserLogService systUserLogService = (SystUserLogService) ApplicationContextUtil.getBean("systUserLogService");
		SystemInfo systemInfo = systemInfoService.getSystemInfo();
		
		String ip = IPUtils.getIpAddress(request);
		if(todayIpMap.containsKey(ip)){
			todayIpMap.put(ip, todayIpMap.get(ip) + 1);
		}else{
			todayIpMap.put(ip, 1);
		}
		session.getSession().setAttribute("curentIp", ip);
		String address = "";
		try {
			address = IPUtils.addressIp(ip);
		} catch (Exception e) {
			log.error("获取ip所在地异常");
		}
		
		log.info("当前用户的sessionId=" + session.getSession().getId());
		log.info("当前用户的登录ip:"+ ip +",所在地:" + address);
		//查看用户ip是否已经存在,判定当前ip是否已访问过网站
		int count = systUserLogService.getSystUserLogCountByIp(ip);
		if(count <= 0){
			systemInfoService.updateSystemInfoVisitTimes("1", "1", systemInfo.getId());
			systemInfo.setIpCount(systemInfo.getIpCount() + 1);
			systemInfo.setTotalVisits(systemInfo.getTotalVisits() + 1);
		}else{
			systemInfoService.updateSystemInfoVisitTimes(null, "1", systemInfo.getId());
			systemInfo.setTotalVisits(systemInfo.getTotalVisits() + 1);
		}
		//保存用户访问日志
		SystUserLog userLog = new SystUserLog();
		userLog.setId(UuidUtil.getUuid());
		userLog.setCreateTime(new Date());
		userLog.setAddress(address);
		userLog.setIp(ip);
		systUserLogService.saveSystUserLog(userLog);
		
	}

	public void sessionDestroyed(HttpSessionEvent session) {
		sessionMap.remove(session.getSession().getId());
		log.info("session销毁：" + session.getSession().getId());
		if(UserUtils.getUserSession().containsKey(session.getSession().getId())){
			System.out.println("用户"+UserUtils.getUserSession().
					get(session.getSession().getId()).getUserName()+"退出登录");
			UserUtils.getUserSession().remove(session.getSession().getId());
			
		}
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		log.info("request创建");
		request = (HttpServletRequest) event.getServletRequest();
	}

	@Override
	public void requestDestroyed(ServletRequestEvent event) {

	}
	
	
}
