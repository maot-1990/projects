package com.pers.task.service.impl;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.pers.task.service.JobService;


public class JobServiceImpl implements JobService{

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		
		System.out.println("任务调度执行：" + context.toString());
	}

	
}
