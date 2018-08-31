package com.pers.blog.view.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.Page;
import com.pers.blog.base.controller.BaseController;
import com.pers.blog.bean.ArticleInfo;
import com.pers.blog.info.service.FirendLinkService;
import com.pers.blog.system.service.SystUserService;
import com.pers.blog.util.Pager;
import com.pers.blog.util.SerachParam;
import com.pers.blog.view.service.ArticleInfoService;

@Controller
@RequestMapping("/viewInfo")
public class ViewInfoController extends BaseController{
	@Resource
	private ArticleInfoService articleInfoService;
	@Resource
	private SystUserService systUserService;
	
	/**
	 * 生活文摘    type=1
	 * @param param
	 * @param request
	 * @param pager
	 * @return
	 */
	@RequestMapping("/live.html")
	public String editInfo(SerachParam param, HttpServletRequest request, Pager pager){
		param.setType("1");
		Page<ArticleInfo> page = articleInfoService.getArticleInfoAllList(param, pager);
		
		request.setAttribute("pager", pager);
		request.setAttribute("page", page);
		return "infodiffusion/infoList";
	}
	
	/**
	 * 网站分享    type=2
	 * @param param
	 * @param request
	 * @param pager
	 * @return
	 */
	@RequestMapping("/tech.html")
	public String siteInfo(SerachParam param, HttpServletRequest request, Pager pager){
		param.setType("2");
		Page<ArticleInfo> page = articleInfoService.getArticleInfoAllList(param, pager);
		
		request.setAttribute("pager", pager);
		request.setAttribute("page", page);
		return "infodiffusion/siteInfoList";
	}
	
	/**
	 * 关于
	 * @return
	 */
	@RequestMapping("/about.html")
	public String about(){
		return "system/about";
	}
	
	/**
	 * 
	 * @param param
	 * @param request
	 * @param pager
	 * @return
	 */
	@RequestMapping("/joke.html")
	public String joke(SerachParam param, HttpServletRequest request, Pager pager){
		param.setType("4");
		pager.setPageSize(6);
		Page<ArticleInfo> page = articleInfoService.getArticleInfoAllList(param, pager);
		
		request.setAttribute("pager", pager);
		request.setAttribute("page", page);
		return "infodiffusion/jokeList";
	}
	
}
