package com.pers.blog.info.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.Page;
import com.pers.blog.bean.ArticleInfo;
import com.pers.blog.util.Pager;
import com.pers.blog.util.SerachParam;
import com.pers.blog.view.service.ArticleInfoService;

@Controller
@RequestMapping("/daily")
public class DailySentenceController{

	@Resource
	private ArticleInfoService articleInfoService;
	
	@RequestMapping("/word.html")
	public String dailyList(Pager pager, SerachParam param, HttpServletRequest request){
		pager.setPageSize(10);
		param.setType("3");
		Page<ArticleInfo> page = articleInfoService.getArticleInfoAllList(param, pager);
		request.setAttribute("pager", pager);
		request.setAttribute("page", page);
		return "myheart/wordList";
	}
}
