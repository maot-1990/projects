package com.pers.blog.task;

import org.apache.log4j.Logger;

import com.pers.blog.system.listener.SessionListener;

/**
 * 每天重置当日访问ip总数，凌晨5分
 * @author maot
 *
 */
public class IPTaskServiceImpl {
	
	private Logger log = Logger.getLogger(IPTaskServiceImpl.class);
	
	public void reSetIP(){
		log.info("当日访问ip量清空任务执行开始");
		SessionListener.todayIpMap.clear();
		log.info("当日访问ip量清空任务执行结束");
	}
}
