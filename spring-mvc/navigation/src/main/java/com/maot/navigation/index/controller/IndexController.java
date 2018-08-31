package com.maot.navigation.index.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maot.navigation.entity.UserWebsiteInfo;
import com.maot.navigation.entity.WebsiteInfo;
import com.maot.navigation.index.service.IndexService;
import com.maot.navigation.vo.WebsiteInfoVo;
import com.pers.util.enums.CommonType;

@Controller
@RequestMapping("/index")
public class IndexController {

	public static Logger log = Logger.getLogger(IndexController.class);
	
	@Resource(type=IndexService.class)
	private IndexService indexService;
	
	/**
	 * 根据分类获取某类网站信息
	 * @param type
	 * @return
	 */
	@RequestMapping("/getWebsiteInfo")
	@ResponseBody
	public Map<String, Object> getWebsiteInfo(String type) throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(StringUtils.isBlank(type)){
			resultMap.put("code", CommonType.responseType.param_error.getCode());
			resultMap.put("msg", CommonType.responseType.param_error.getValue());
			return resultMap;
		}
		List<WebsiteInfoVo> infoVos = indexService.getWebsiteInfo(type);
		
		resultMap.put("code", CommonType.responseType.success.getCode());
		resultMap.put("msg", CommonType.responseType.success.getValue());
		resultMap.put("data", infoVos);
		return resultMap;
	}
	
	/**
	 * 获取推荐网站
	 * @return
	 */
	@RequestMapping("/hotWebsite")
	@ResponseBody
	public Map<String, Object> hotWebsite() throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<WebsiteInfo> websiteInfos = indexService.getHotWeisite();
		resultMap.put("code", CommonType.responseType.success.getCode());
		resultMap.put("msg", CommonType.responseType.success.getValue());
		resultMap.put("data", websiteInfos);
		return resultMap;
	}
	
	/**
	 * 获取用户自己收藏的网站
	 * @return
	 */
	@RequestMapping("/userWebsiteInfo")
	public Map<String, Object> userWebsiteInfo(HttpSession session) throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String userId = session.getAttribute("userId").toString();
		List<UserWebsiteInfo> infos = indexService.getUserWebsiteInfo(userId);
		
		resultMap.put("code", CommonType.responseType.success.getCode());
		resultMap.put("msg", CommonType.responseType.success.getValue());
		resultMap.put("data", infos);
		return resultMap;
		
	}
}
