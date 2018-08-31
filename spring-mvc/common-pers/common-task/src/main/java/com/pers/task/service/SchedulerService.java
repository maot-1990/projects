package com.pers.task.service;

import org.quartz.Job;

import com.pers.task.bean.JobBean;

public interface SchedulerService {
	
	/**
	 * 添加定时任务
	 * @return
	 */
	public boolean addJob(JobBean jobBean, Class<? extends Job> clszz) throws Exception;

}
