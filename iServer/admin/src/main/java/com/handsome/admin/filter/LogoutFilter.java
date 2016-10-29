package com.handsome.admin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;

import com.handsome.admin.constent.SessionKeyConstent;

public class LogoutFilter implements Filter
{

	private FilterConfig fc;
	private ServletContext sc;

	public void init(FilterConfig filterConfig)
	{
		this.fc = filterConfig;
		this.sc = filterConfig.getServletContext();
	}

	public void destroy()
	{
		this.sc = null;
		this.fc = null;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filterChain) throws ServletException, IOException
	{

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		// 请求的uri
		String uri = request.getRequestURI();
		//使session失效
		request.getSession(false);
		HttpSession hs = request.getSession();
		hs.invalidate();
		
		//重定向到登录页面
		response.sendRedirect(request.getContextPath()
				+ "/auth/login.do");
		return;

	}

}
