package com.handsome.admin.controller;

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
@RequestMapping("/")
public class IndexViewController
{

	/**
	 * 主菜单请求
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public ModelAndView main()
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("/main");
		return view;
	}
	
}
