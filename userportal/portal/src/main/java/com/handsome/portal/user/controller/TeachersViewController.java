/*
 * 
 */
package com.handsome.portal.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView teacherDetail()
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("/user/teacherdetail");
		return view;
	}

}
