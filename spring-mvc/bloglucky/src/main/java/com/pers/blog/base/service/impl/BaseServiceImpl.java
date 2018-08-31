package com.pers.blog.base.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pers.blog.base.dao.BaseDao;
import com.pers.blog.base.service.BaseService;

@Service
public class BaseServiceImpl implements BaseService{
	@Resource
	public BaseDao baseDao;
	
	public Date getCruentDate() {
		return baseDao.getCruentDate();
	}

	
}
