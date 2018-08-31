package com.maot.navigation.index.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.maot.navigation.dao.UserWebsiteInfoDao;
import com.maot.navigation.dao.WebsiteInfoDao;
import com.maot.navigation.dao.WebsiteTypeDao;
import com.maot.navigation.entity.UserWebsiteInfo;
import com.maot.navigation.entity.WebsiteInfo;
import com.maot.navigation.entity.WebsiteType;
import com.maot.navigation.index.service.IndexService;
import com.maot.navigation.vo.WebsiteInfoVo;

@Service
public class IndexServiceImpl implements IndexService{

	private static Logger log = Logger.getLogger(IndexServiceImpl.class);
	
	@Resource
	private WebsiteInfoDao websiteInfoDao;
	@Resource
	private UserWebsiteInfoDao userWebsiteInfoDao;
	@Resource
	private WebsiteTypeDao websiteTypeDao;
	

	@Override
	public List<WebsiteInfoVo> getWebsiteInfo(String type) throws Exception{
		List<WebsiteInfoVo> infoVos = new ArrayList<WebsiteInfoVo>();
		List<WebsiteType> websiteTypes = websiteTypeDao.getByPType(type);
		if(websiteTypes != null && websiteTypes.size() > 0){
			for(WebsiteType websiteType : websiteTypes){
				List<WebsiteInfo> infos = websiteInfoDao.getListByType(websiteType.getType());
				WebsiteInfoVo infoVo = new WebsiteInfoVo(websiteType.getType(), websiteType.getName(), 
						infos);
				infoVos.add(infoVo);
			}
		}
		
		return infoVos;
	}


	@Override
	public List<WebsiteInfo> getHotWeisite() {
		
		return websiteInfoDao.getHotWeisite();
	}


	@Override
	public List<UserWebsiteInfo> getUserWebsiteInfo(String userId) throws Exception {
		return userWebsiteInfoDao.getUserWebsiteInfo(userId);
	}
	
}
