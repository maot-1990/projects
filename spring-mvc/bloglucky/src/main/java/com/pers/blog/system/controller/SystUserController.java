package com.pers.blog.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pers.blog.bean.SystUser;
import com.pers.blog.system.service.SystUserService;
import com.pers.blog.util.MD5Util;
import com.pers.blog.util.UserUtils;

@Controller
@RequestMapping("/user")
public class SystUserController {

	private Logger log = Logger.getLogger(SystUserController.class);
	@Resource
	private SystUserService systUserService;
	
	@RequestMapping("/recent")
	@ResponseBody
	public List<SystUser> getSystUserRecent(){
		List<SystUser> users = systUserService.getSystUserRecent();
		return users;
	}
	
	@RequestMapping("/login")
	public String goLogin(){
		return "system/login";
	}
	
	@RequestMapping("/goLogin")
	@ResponseBody
	public Map<String, Object> goLogin(HttpServletRequest request, SystUser user){
		System.out.println("sessionId="+request.getSession().getId());
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtils.isBlank(user.getUserName())){
			map.put("success", "false");
			map.put("msg", "用户名不能为空");
			return map;
		}
		if(StringUtils.isBlank(user.getPwd())){
			map.put("success", "false");
			map.put("msg", "密码不能为空");
			return map;
		}
		boolean isLogin = UserUtils.isLogin(request.getSession());
		if(isLogin){
			map.put("success", "false");
			map.put("msg", "你已登陆！");
			return map;
		}
		
		SystUser loginUser = systUserService.selectSystUserByNameAndPwd(user.getUserName(),MD5Util.encodeMD5(user.getPwd()));
		if(loginUser == null){
			map.put("success", "false");
			map.put("msg", "用户名或密码不正确！");
			return map;
		}
		loginUser.setPwd("");
		UserUtils.put(request.getSession(), loginUser);
		request.getSession().setAttribute("user", loginUser);
		log.info("登陆成功");
		map.put("success", "true");
		map.put("msg", "注册成功");
		return map;
		
	}
}
