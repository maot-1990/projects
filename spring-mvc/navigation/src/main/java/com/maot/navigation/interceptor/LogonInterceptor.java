package com.maot.navigation.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.maot.navigation.util.UserManager;

public class LogonInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception excep)
			throws Exception {
		System.out.println("afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj, ModelAndView mav) throws Exception {
		System.out.println("postHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		System.out.println("preHandle");
		HttpSession session = request.getSession();
		String userId = session.getAttribute("userId") != null ? session.getAttribute("userId").toString() : "";
		if(!UserManager.isLogon(userId, session)){
			response.sendRedirect(request.getContextPath() + "/logon.html");
		}
		return true;
	}

	
}
