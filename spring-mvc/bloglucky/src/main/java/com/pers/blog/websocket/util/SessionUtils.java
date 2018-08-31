package com.pers.blog.websocket.util;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.Session;

/**
 * 功能说明：用来存储业务定义的sessionId和连接的对应关系 利用业务逻辑中组装的sessionId获取有效连接后进行后续操作
 * 作者：liuxing(2014-12-26 02:32)
 */
public class SessionUtils {

	public static Map<String, Session>  scoketSession = new HashMap<String, Session>();

	public static Map<String, Session> getScoketSession() {
		return scoketSession;
	}

	public static void setScoketSession(Map<String, Session> scoketSession) {
		SessionUtils.scoketSession = scoketSession;
	}

	
	

	

}