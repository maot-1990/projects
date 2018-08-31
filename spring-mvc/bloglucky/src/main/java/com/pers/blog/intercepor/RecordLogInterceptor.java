package com.pers.blog.intercepor;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pers.blog.base.service.BaseService;
import com.pers.blog.info.service.FirendLinkService;
import com.pers.blog.system.dao.SystUserLogDao;
import com.pers.blog.system.service.LeaveMessageService;
import com.pers.blog.system.service.SystUserService;
import com.pers.blog.view.service.ArticleInfoService;

@Component
public class RecordLogInterceptor implements HandlerInterceptor {

	@Resource
	private BaseService baseService;
	@Resource
	private ArticleInfoService articleInfoService;
	@Resource
	private LeaveMessageService leaveMessageService;
	@Resource
	private SystUserService systUserService;
	@Resource
	private FirendLinkService firendLinkService;
	@Resource
	private SystUserLogDao systUserLogDao;
	private Logger log = Logger.getLogger(RecordLogInterceptor.class);

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception exc)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj, ModelAndView view)
			throws Exception {
	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj) throws Exception {
		log.info("日志拦截器");
		return true;
	}

}
