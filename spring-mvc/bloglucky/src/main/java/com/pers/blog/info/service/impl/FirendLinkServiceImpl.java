package com.pers.blog.info.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pers.blog.bean.FirendLink;
import com.pers.blog.info.dao.FirendLinkDao;
import com.pers.blog.info.service.FirendLinkService;

@Service
public class FirendLinkServiceImpl implements FirendLinkService{

	@Resource
	private FirendLinkDao firendLinkDao;
	
	@Override
	public List<FirendLink> getFirendLinkList() {
		return firendLinkDao.getFirendLinkList();
	}

	
}
