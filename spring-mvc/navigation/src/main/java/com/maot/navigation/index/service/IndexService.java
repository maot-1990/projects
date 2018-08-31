package com.maot.navigation.index.service;

import java.util.List;

import com.maot.navigation.entity.UserWebsiteInfo;
import com.maot.navigation.entity.WebsiteInfo;
import com.maot.navigation.vo.WebsiteInfoVo;

public interface IndexService {

	public List<WebsiteInfoVo> getWebsiteInfo(String type) throws Exception;
	
	public List<WebsiteInfo> getHotWeisite() throws Exception;
	
	public List<UserWebsiteInfo> getUserWebsiteInfo(String userId) throws Exception;
}
