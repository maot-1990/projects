package com.pers.blog.system.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.pers.blog.util.ApplicationContextUtil;

public class SystemInfoFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		chain.doFilter(req, res);
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		ApplicationContextUtil.setContext(config.getServletContext());
	}

	

	
}
