package com.handsome.admin.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.handsome.admin.auth.service.SiteUserService;

/**
 * 
 * @author dell
 *
 */
@Controller
@RequestMapping("/auth")
public class IndexViewController
{

	@Autowired
	@Qualifier(value = "siteUserServiceImpl")
	private SiteUserService siteUserService;

	/**
	 * 登录页面请求
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public ModelAndView login()
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("/auth/login");
		return view;
	}

	/**
	 * 注册页面请求
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/signup.do", method = RequestMethod.GET)
	public ModelAndView signup()
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("/auth/signup");
		return view;
	}
	
}
