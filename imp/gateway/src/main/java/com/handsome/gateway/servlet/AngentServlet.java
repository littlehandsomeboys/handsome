/**
 * 
 */
package com.handsome.gateway.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.handsome.imp.base.agent.InterfaceManager;


/**
 * @author dell
 *
 */
public class AngentServlet extends HttpServlet
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(AngentServlet.class);

	/**
	 * servletConfig
	 */
	private ServletConfig servletConfig;

	/**
	 * @throws ServletException
	 * 
	 */
	public AngentServlet() throws ServletException
	{

	}

	/**
	 * @see Servlet#init(ServletConfig)  
	 * 
	 * @return
	 * @throws ServletException
	 */
	public void init(ServletConfig config) throws ServletException
	{
		servletConfig = config;
		super.init(config);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		// System.out.println("调用doGet方法");
		// response.setContentType("text;html;charset=utf-8");
		// String username = request.getParameter("username");
		// String password = request.getParameter("password");
		// System.out.println("username=" + username);
		// System.out.println("password=" + password);
		// System.out.println("servlet test success....");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
	{
		// 获得username请求参数
		String username = request.getParameter("username");
		/*
		 * 字符编码转换。 HTTP请求的默认字符编码为ISO-8859-1，如果请求中包含中文， 需要把它转换为GB2312中文编码。
		 */
		if (username != null)
		{
			try
			{
				username = new String(username.getBytes("UTF-8"), "UTF-8");
			}
			catch (UnsupportedEncodingException e)
			{
				logger.error(e.toString(), e);
			}
		}
//		if (username == null)
//		{
//			// 仅仅为了演示response.sendError()的用法。“禁止访问”
//			try
//			{
//				response.sendError(response.SC_FORBIDDEN);
//			}
//			catch (IOException e)
//			{
//				logger.error(e.toString(), e);
//			}
//			return;
//		}
		// 设置HTTP响应的正文的MIME类型及字符编码
		response.setContentType("text;html;charset=utf-8");
		/* 输出HTML文档 */
		PrintWriter out = null;
		
		WebApplicationContext wac = WebApplicationContextUtils 
                .getRequiredWebApplicationContext(servletConfig.getServletContext()); 
		InterfaceManager im = (InterfaceManager) wac.getBean("commonFacet");
		im.doBusiness(null);
		
		try
		{
			out = response.getWriter();
			out.println("<html><head><title>HelloServlet</TITLE></head>");
			out.println("<body>");
			out.println("你好: " + username);
			out.println("</body></html>");
		}
		catch (IOException e)
		{
			logger.error(e.toString(), e);
		}
		finally
		{
			if (null != out)
			{
				try
				{
					out.close(); // 关闭PrintWriter
				}
				catch (Exception e)
				{
					logger.error(e.toString(), e);
				}
			}
		}

		// System.out.println("after close():" + response.isCommitted()); //
		// true
	}

}
