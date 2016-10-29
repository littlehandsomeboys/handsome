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

import org.springframework.http.HttpStatus;

import com.handsome.admin.constent.SessionKeyConstent;

public class LoginFilter implements Filter
{

	private FilterConfig fc;
	private ServletContext sc;
	private static String[] notFilter = new String[]
	{ "/login.do", "/signup.do", ".jpg", ".JPG", ".jepg", ".JEPG", ".gif",
			".GIF", ".png", ".PNG", ".js", ".css", ".html", ".json" };
	private String pass;

	private static String[] loginNotFilter = new String[]
	{ "/login.do", "/signup.do", ".jpg", ".JPG", ".jepg", ".JEPG", ".gif",
			".GIF", ".png", ".PNG", ".js", ".css", ".html", ".json" };
	private String loginPass;

	public void init(FilterConfig filterConfig)
	{
		this.fc = filterConfig;
		this.sc = filterConfig.getServletContext();

		// 不过滤的uri
		this.pass = filterConfig.getInitParameter("pass");
		if (null != pass)
		{
			notFilter = pass.split(",");
		}

		// 登录后不重定向的uri
		this.loginPass = filterConfig.getInitParameter("loginPass");
		if (null != loginPass)
		{
			loginNotFilter = loginPass.split(",");
		}
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
		// 是否过滤
		boolean doFilter = true;
		for (String s : notFilter)
		{
			if (uri.endsWith(s))
			{
				// 如果uri中包含不过滤的uri，则不进行过滤
				doFilter = false;
				break;
			}
		}

		if (doFilter)
		{
			// 执行过滤
			// 从session中获取登录者实体
			Object obj = request.getSession().getAttribute(
					SessionKeyConstent.SESSION_KEY_OBJ_USER_BEAN);
			if (null == obj)
			{
				boolean isAjaxRequest = isAjaxRequest(request);
				if (isAjaxRequest)
				{
					response.setCharacterEncoding("UTF-8");
					response.sendError(HttpStatus.UNAUTHORIZED.value(),
							"您已经太长时间没有操作,请刷新页面");
					return;
				}
				response.sendRedirect(request.getContextPath()
						+ "/auth/login.do");
				return;
			}
			// 如果session中存在登录者实体，则继续
			else
			{
				// 是否是非法url，是的话需要重定向到主页
				doFilter = true;
				for (String s : loginNotFilter)
				{
					if (uri.endsWith(s))
					{
						doFilter = false;
						break;
					}
				}
				if (!doFilter)
				{
					filterChain.doFilter(request, response);
				}
				else
				{
					response.sendRedirect(request.getContextPath()
							+ "/main.do");
				}
			}
		}
		else
		{
			// 如果不执行过滤，则继续
			filterChain.doFilter(request, response);
		}

	}

	/**
	 * 判断是否为Ajax请求 <功能详细描述>
	 * 
	 * @param request
	 * @return 是true, 否false
	 * @see [类、类#方法、类#成员]
	 */
	public static boolean isAjaxRequest(HttpServletRequest request)
	{
		String header = request.getHeader("X-Requested-With");
		if (header != null && "XMLHttpRequest".equals(header))
			return true;
		else
			return false;
	}

	public String getPass()
	{
		return pass;
	}

	public void setPass(String pass)
	{
		this.pass = pass;
	}

	public String getLoginPass()
	{
		return loginPass;
	}

	public void setLoginPass(String loginPass)
	{
		this.loginPass = loginPass;
	}

}
