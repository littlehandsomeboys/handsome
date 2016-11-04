package com.handsome.admin.siteuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.handsome.siteuser.api.service.SiteUserService;

/**
 * 
 * @author dell
 *
 */
@Controller
@RequestMapping("/siteuser")
public class SiteUserViewController
{

	@Autowired
	@Qualifier(value = "siteUserServiceImpl")
	private SiteUserService siteUserService;

	/**
	 * 请求用户列表
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/siteuserlist.do", method = RequestMethod.GET)
	public ModelAndView login()
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("/siteuser/siteuserlist");
		return view;
	}

}
