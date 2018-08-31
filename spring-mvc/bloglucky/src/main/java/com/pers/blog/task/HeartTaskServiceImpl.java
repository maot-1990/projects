package com.pers.blog.task;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.pers.blog.base.dao.BaseDao;

public class HeartTaskServiceImpl {

	private Logger log = Logger.getLogger(HeartTaskServiceImpl.class);
	@Resource
	private BaseDao baseDao;
	
	public void cruentDate(){
		Date date = baseDao.getCruentDate();
		log.info("当前时间为：" + date);
	}
}
