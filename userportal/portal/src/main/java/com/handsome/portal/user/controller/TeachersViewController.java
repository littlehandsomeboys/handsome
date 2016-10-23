/*
 * 
 */
package com.handsome.portal.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.handsome.portal.user.bean.Teacher;
import com.handsome.siteuser.api.bean.SiteUser;
import com.handsome.siteuser.api.service.SiteUserService;

/**
 * 
 * @author dell
 *
 */
@Controller
@RequestMapping("/teacher")
public class TeachersViewController
{

	public TeachersViewController()
	{
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	@Qualifier(value = "siteUserService")
	private SiteUserService siteUserService;
	
	/**
	 * 列表页面
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/teacherList.do", method = RequestMethod.GET)
	public ModelAndView teacherList()
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("/user/teacherlist");
		return view;
	}
	
	/**
	 * 列表页面
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/teacherDetail.do", method = RequestMethod.GET)
	public ModelAndView teacherDetail(@ModelAttribute Teacher teacher)
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("/user/teacherdetail");
		
		SiteUser siteUser = siteUserService.getSiteUserByUserName(teacher
				.getAccount());
		view.addObject("obj", siteUser);
		return view;
	}

}
