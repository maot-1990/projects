/*package com.pers.blog.websocket.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

import org.apache.tomcat.websocket.WsSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pers.blog.websocket.util.SessionUtils;

@RestController
@RequestMapping("/webScoket")
public class WebScoketController {

	@RequestMapping("/send")
	public void sendMessage(HttpServletRequest request){
		try {
			System.out.println("发送时的sessionId=" + request.getSession().getId());
			WsSession session = (WsSession)SessionUtils.getScoketSession().get(request.getSession().getId());
			session.getBasicRemote().sendText("1234567");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
*/