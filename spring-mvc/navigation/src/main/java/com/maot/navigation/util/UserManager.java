package com.maot.navigation.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class UserManager {
	
	private static Logger log = Logger.getLogger(UserManager.class);
	
	public static Map<String, Object> userMap = new ConcurrentHashMap<String, Object>();
	
	public static void addUser(String userId, HttpSession session){
		if(userMap.containsKey(userId)){
			HttpSession userSession = (HttpSession) userMap.get(userId);
			userMap.remove(userId);
			userSession.invalidate();
		}
		log.info("登录用户：" + userId);
		session.setAttribute("userId", userId);
		userMap.put(userId, session);
		log.info("sessionMap:" + userMap);
	}
	
	public static void removeUser(String userId, HttpSession session){
		log.info("退出用户:" + userId);
		log.info("退出前，sessionMap:" + userMap);
		userMap.remove(userId);
		session.invalidate();
		log.info("退出后，sessionMap:" + userMap);
	}

	public static Boolean isLogon(String userId, HttpSession session){
		if(StringUtils.isBlank(userId)){
			return false;
		}
		if(userMap.containsKey(userId)){
			HttpSession userSession = (HttpSession) userMap.get(userId);
			if(session != null && session.getId().equals(userSession.getId())){
				return true;
			}
		}
		return false;
	}
}
