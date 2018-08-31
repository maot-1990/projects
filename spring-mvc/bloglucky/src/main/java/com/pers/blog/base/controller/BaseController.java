package com.pers.blog.base.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pers.blog.base.service.BaseService;
import com.pers.util.date.DateUtils;

@Controller
public class BaseController {
	@Resource
	private BaseService baseService;
	
	@RequestMapping("/getCruentDate")
	@ResponseBody
	public String getCruentDate() throws Exception{
		Date date =  baseService.getCruentDate();
		System.out.println("当前数据库时间为：" + DateUtils.format(date, "yyyy-MM-dd hh:mm:ss"));
		return DateUtils.format(date, "yyyy-MM-dd hh:mm:ss");
	}
	
	@RequestMapping("/")
	public String index(HttpServletRequest request){
		
		return "index";
	}
}
