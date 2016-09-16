/*
 * 
 */
package com.handsome.portal.product.controller;

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
@RequestMapping("/product")
public class ProductViewController
{

	public ProductViewController()
	{
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 登录页面请求
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/productlist.do", method = RequestMethod.GET)
	public ModelAndView productlist()
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("/product/productlist");
		return view;
	}

}
