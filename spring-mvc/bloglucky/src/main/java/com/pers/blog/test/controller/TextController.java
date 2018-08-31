package com.pers.blog.test.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pers.connection.util.ConnectionPool;



@Controller
@RequestMapping("/text")
public class TextController {

	private static Logger log = Logger.getLogger(TextController.class);
	
	@Resource
	private ConnectionPool connectionPool;
	
	public void broadcast(String relationId, int userCode, String message) {
		/*if (SessionUtils.hasConnection(relationId, userCode)) {
			SessionUtils.get(relationId, userCode).getAsyncRemote()
					.sendText(message);
		} else {
			throw new NullPointerException(SessionUtils.getKey(relationId,
					userCode) + "Connection does not exist");
		}*/
	}
	
	@RequestMapping("/go")
	@ResponseBody
	public Map<String, Object> go(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		Thread thread = new Thread(new MineThread());
		Thread threadDaemon = new Thread(new MineDaemonThread());
		
		threadDaemon.setDaemon(true);
		thread.start();
		threadDaemon.start();
		
		return map;
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread(new MineThread());
		Thread threadDaemon = new Thread(new MineDaemonThread());
		
		//threadDaemon.setDaemon(true);
		thread.start();
		threadDaemon.start();
	}
	
	@RequestMapping("/closeCon")
	@ResponseBody
	public Map<String, Object> closeCon(){
		Map<String, Object> map = new HashMap<String, Object>();
		connectionPool.destroy();
		
		map.put("code", "00");
		map.put("msg", "数据连接已关闭");
		return map;
		
	}
}
