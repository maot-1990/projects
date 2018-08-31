/*package com.pers.blog.websocket.service;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;
import org.apache.tomcat.websocket.WsSession;

import com.pers.blog.websocket.util.SessionUtils;

@ServerEndpoint("/websocket")
public class WebsocketService {
	private Logger log = Logger.getLogger(WebsocketService.class);

	*//**
	 * 打开连接时触发
	 * 
	 * @param relationId
	 * @param userCode
	 * @param session
	 *//*
	@OnOpen
	public void onOpen(Session session) {
		//System.out.println("onOpen,sessionId=" + session.getId());
		SessionUtils.getScoketSession().put(((WsSession)session).getHttpSessionId(), session);
	}

	*//**
	 * 收到客户端消息时触发
	 * 
	 * @param relationId
	 * @param userCode
	 * @param message
	 * @return
	 *//*
	@OnMessage
	public String onMessage(String message) {
		System.out.println("后台收到的信息message:" + message);
		return "Got your message (" + message + ").Thanks !";
	}

	*//**
	 * 异常时触发
	 * 
	 * @param relationId
	 * @param userCode
	 * @param session
	 *//*
	@OnError
	public void onError(Throwable throwable, Session session) {
		System.out.println("OnError");

	}

	*//**
	 * 关闭连接时触发
	 * 
	 * @param relationId
	 * @param userCode
	 * @param session
	 *//*
	@OnClose
	public void onClose(Session session) {
		SessionUtils.getScoketSession().remove(((WsSession)session).getHttpSessionId());
	}

}
*/