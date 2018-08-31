package com.maot.navigation.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class SessionManager {
	
	private static Logger log = Logger.getLogger(SessionManager.class);
	
	public static Map<String, Object> sessionMap = new ConcurrentHashMap<String, Object>();
	
	public static void addSession(HttpSession session){
		log.info("创建session:" + session.getId());
		sessionMap.put(session.getId(), session);
		log.info("sessionMap:" + sessionMap);
	}
	
	public static void removeSession(HttpSession session){
		log.info("销毁session:" + session.getId());
		log.info("销毁前，sessionMap:" + sessionMap);
		sessionMap.remove(session.getId());
		log.info("销毁后，sessionMap:" + sessionMap);
	}

	public static Boolean isLogon(HttpSession session){
		if(session != null && sessionMap.containsKey(session.getId())){
			return true;
		}else{
			return false;
		}
	}
}
