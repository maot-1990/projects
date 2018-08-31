package com.pers.task.bean;

import java.util.Date;
import java.util.Map;
import java.util.Set;

public class JobBean {

	/**jobId*/
	private String jobId;
	/** 任务名称 */
	protected String jobName;
	/** 任务分组 */
	protected String jobGroup;
	/**JobBean对应的Class全称*/
	protected String jobBeanName;
	/**JOB类型， local ， remote*/
	protected String jobType;
	/**
	 * Job注册类型，增加、删除、修改
	 * 详见JobConstantParams的JOB注册类型
	 */
	private String jobRegType;
	/**
	 * JOB执行类型 ： 立即，指定时间，默认为立即执行
	 * 详见JobConstantParams的JOB执行类型
	 */
	private Integer jobExecuteType;
	/**
	 * 时间表类型
	 * 1：按表达式方式（CronTrigger）
	 * 2：按简单触发器：（SimpleTrigger）
	 * 3：按日期表：（DailyTimeIntervalTrigger） 
	 */
	private Integer scheduleType;
	/**JOB参数*/
	protected Map<String,Object> jobDataMap;
	/**描述*/
	protected String desc;
	/**开始执行时间*/
	private Date startTime;
	/**结束执行时间*/
	private Date endTime;
	/**重复执行次数*/
	private Integer repeatCount;
	/**重复间隔的秒数*/
	private Integer repeatInterval;
	/**	间隔单位，参见 DateBuilder.IntervalUnit*/
	private String intervalUnit;
	/**指定一周之内的哪几天进行执行，此值必须为1-7之中*/
	private Set<Integer> daysOfWeek;
	
	/** 表达式 */
	private String cronExp;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public String getJobBeanName() {
		return jobBeanName;
	}

	public void setJobBeanName(String jobBeanName) {
		this.jobBeanName = jobBeanName;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobRegType() {
		return jobRegType;
	}

	public void setJobRegType(String jobRegType) {
		this.jobRegType = jobRegType;
	}

	public Integer getJobExecuteType() {
		return jobExecuteType;
	}

	public void setJobExecuteType(Integer jobExecuteType) {
		this.jobExecuteType = jobExecuteType;
	}

	public Integer getScheduleType() {
		return scheduleType;
	}

	public void setScheduleType(Integer scheduleType) {
		this.scheduleType = scheduleType;
	}

	public Map<String, Object> getJobDataMap() {
		return jobDataMap;
	}

	public void setJobDataMap(Map<String, Object> jobDataMap) {
		this.jobDataMap = jobDataMap;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getRepeatCount() {
		return repeatCount;
	}

	public void setRepeatCount(Integer repeatCount) {
		this.repeatCount = repeatCount;
	}

	public Integer getRepeatInterval() {
		return repeatInterval;
	}

	public void setRepeatInterval(Integer repeatInterval) {
		this.repeatInterval = repeatInterval;
	}

	public String getIntervalUnit() {
		return intervalUnit;
	}

	public void setIntervalUnit(String intervalUnit) {
		this.intervalUnit = intervalUnit;
	}

	public Set<Integer> getDaysOfWeek() {
		return daysOfWeek;
	}

	public void setDaysOfWeek(Set<Integer> daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}

	public String getCronExp() {
		return cronExp;
	}

	public void setCronExp(String cronExp) {
		this.cronExp = cronExp;
	}
	
	
}
