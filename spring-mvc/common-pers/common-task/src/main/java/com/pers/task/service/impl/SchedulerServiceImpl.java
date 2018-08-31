package com.pers.task.service.impl;

import java.text.ParseException;
import java.util.Date;

import javax.annotation.Resource;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.springframework.stereotype.Service;

import com.pers.task.bean.JobBean;
import com.pers.task.service.SchedulerService;

@Service
public class SchedulerServiceImpl implements SchedulerService{

	@Resource
	private Scheduler scheduler;
	
	@Override
	public boolean addJob(JobBean jobBean, Class<? extends Job> clszz) throws Exception{
		
		JobBuilder jobBuilder = JobBuilder.newJob(clszz);
		jobBuilder.withDescription(jobBean.getDesc());
		if(jobBean.getJobDataMap() != null){
			jobBuilder.setJobData(new JobDataMap(jobBean.getJobDataMap()));
		}
		JobDetail jobDetail = jobBuilder.withIdentity(jobBean.getJobName(), jobBean.getJobGroup()).build();
		Trigger trigger = getTrigger(jobBean);
		scheduler.scheduleJob(jobDetail, trigger);
		return true;
	}

	private Trigger getTrigger(JobBean jobBean){
		Trigger trigger = null;
		if(jobBean.getScheduleType() == 1){ //CronTrigger
			CronTriggerImpl cronTrigger = new CronTriggerImpl();
			cronTrigger.setGroup(jobBean.getJobGroup());
			cronTrigger.setName(jobBean.getJobName());
			cronTrigger.setDescription(jobBean.getDesc());
			if(jobBean.getStartTime() == null){
				cronTrigger.setStartTime(new Date());
			}else{
				cronTrigger.setStartTime(jobBean.getStartTime());
			}
			
			try {
				cronTrigger.setCronExpression(jobBean.getCronExp());
			} catch (ParseException e) {
				throw new RuntimeException("解析表达式错误" + jobBean.getCronExp());
			}
			trigger = cronTrigger;
		}else if(jobBean.getScheduleType() == 2){ //SimpleTrigger
			SimpleTriggerImpl simpleTrigger = new SimpleTriggerImpl();
			simpleTrigger.setGroup(jobBean.getJobGroup());
			simpleTrigger.setName(jobBean.getJobName());
			simpleTrigger.setDescription(jobBean.getDesc());
			if(jobBean.getRepeatCount() != null){
				simpleTrigger.setRepeatCount(jobBean.getRepeatCount());
			}
			if(jobBean.getRepeatInterval() != null){
				simpleTrigger.setRepeatInterval(jobBean.getRepeatInterval());
			}
			if(jobBean.getStartTime() != null){
				simpleTrigger.setStartTime(jobBean.getStartTime());
			}else{
				simpleTrigger.setStartTime(new Date());
			}
			trigger = simpleTrigger;
			
		}
		
		return trigger;
	}
}
