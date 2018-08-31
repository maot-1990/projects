package com.pers.blog.intercepor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pers.blog.base.service.BaseService;
import com.pers.blog.bean.ArticleInfo;
import com.pers.blog.bean.FirendLink;
import com.pers.blog.bean.MessageBoard;
import com.pers.blog.bean.SystUser;
import com.pers.blog.bean.SystemInfo;
import com.pers.blog.info.service.FirendLinkService;
import com.pers.blog.system.dao.SystUserLogDao;
import com.pers.blog.system.listener.SessionListener;
import com.pers.blog.system.service.LeaveMessageService;
import com.pers.blog.system.service.SystUserService;
import com.pers.blog.system.service.SystemInfoService;
import com.pers.blog.view.service.ArticleInfoService;

@Component
public class DataInfoInterceptor implements HandlerInterceptor{

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
	private Logger log = Logger.getLogger(RecordLogInterceptor.class);
	@Resource
	private SystUserLogDao systUserLogDao;
	@Resource
	private SystemInfoService systemInfoService;

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
		try {
			log.info("拦截器获取数据开始，请求用户ip:" + request.getSession().getAttribute("curentIp") + ",请求url:" + request.getRequestURI());
			List<ArticleInfo> articleInfoList = articleInfoService.getArticleInfoList(null,6);
			List<ArticleInfo> hotClickList = articleInfoService.getHotClick(null, 6);
			List<ArticleInfo> newsInfo = articleInfoService.getNewArticleInfo("5", 6);
			List<MessageBoard> messageBoardList = leaveMessageService.getLeaveMessage();
			List<SystUser> recentUser = systUserService.getSystUserRecent();
			ArticleInfo daily = articleInfoService.getArticleInfoDailySentent();
			List<FirendLink> firendLinks = firendLinkService.getFirendLinkList();
			SystemInfo systemInfo = systemInfoService.getSystemInfo();
			
			request.setAttribute("firendLinks", firendLinks);
			request.setAttribute("daily", daily);
			request.setAttribute("articleInfoList", articleInfoList);
			request.setAttribute("hotClickList", hotClickList);
			request.setAttribute("newsInfo", newsInfo);
			request.setAttribute("messageBoardList", messageBoardList);
			request.setAttribute("recentUser", recentUser);
			request.setAttribute("systemInfo", systemInfo);
			
			request.getSession().setAttribute("todayIpMap", SessionListener.todayIpMap);
			log.info("拦截器获取数据结束");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
