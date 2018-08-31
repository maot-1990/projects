package com.pers.blog.util;

import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ApplicationContextUtil {

	public static ServletContext context = null;
	
	public static Object getBean(String beanName) {
		WebApplicationContext web = WebApplicationContextUtils
				.getWebApplicationContext(ApplicationContextUtil.context);
		return web.getBean(beanName);
	}

	public static ServletContext getContext() {
		return context;
	}

	public static void setContext(ServletContext context) {
		ApplicationContextUtil.context = context;
	}
	
}
