package com.pers.blog.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import com.pers.blog.bean.SystUser;
import com.pers.blog.system.listener.SessionListener;

public class UserUtils {
	
	private static Map<String, SystUser> userSession = new ConcurrentHashMap<String, SystUser>();
	
	public static void put(HttpSession session, SystUser user){
		if(userSession.size() > 0){
			Set<Entry<String, SystUser>> set = userSession.entrySet();
			Iterator<Entry<String, SystUser>> it = set.iterator();
			while(it.hasNext()){
				Entry<String, SystUser> en = it.next();
				if(user.getId().equals(en.getValue().getId())){
					HttpSession curSession = SessionListener.sessionMap.get(en.getKey());
					if(curSession != null){
						curSession.invalidate();
					}
				}
			}
		}
		userSession.put(session.getId(), user);
	}
	
	public static void remove(String sessionId, SystUser user){
		userSession.remove(sessionId);
	}
	
	/**
	 * 获取当前登录的总用户
	 * @return
	 */
	public static Integer getLogonUserCount(){
		return userSession.size(); 
	}
	
	/**
	 * 查询该用户是否登录
	 * @param session
	 * @return
	 */
	public static boolean isLogin(HttpSession session){
		if(userSession.containsKey(session.getId())){
			return true;
		}else{
			return false;
		}
	}
	
	public static Map<String, SystUser> getUserSession() {
		return userSession;
	}

	public static void setUserSession(Map<String, SystUser> userSession) {
		UserUtils.userSession = userSession;
	}


}