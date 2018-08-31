package com.maot.test.quartz.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pers.task.bean.JobBean;
import com.pers.task.service.SchedulerService;
import com.pers.task.service.impl.JobServiceImpl;

@Controller
@RequestMapping("/quartz")
public class QuartzController {

	@Resource
	private SchedulerService schedulerService;
	
	@RequestMapping("/addJob")
	@ResponseBody
	public Map<String, Object> addJob(String jobName, String jobGroup){
		Map<String, Object> map = new HashMap<String, Object>();
		/*JobBean jobBean = new JobBean();
		jobBean.setJobName(jobName);
		jobBean.setJobGroup(jobGroup);
		jobBean.setScheduleType(1);
		jobBean.setCronExp("0/10 * * * * ?");
		try {
			schedulerService.addJob(jobBean, JobServiceImpl.class);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		System.out.println("addjob");
		map.put("job", "hehe");
		return map;
	}
}
