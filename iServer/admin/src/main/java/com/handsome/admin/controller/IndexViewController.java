package com.handsome.admin.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.handsome.admin.constent.SessionKeyConstent;
import com.handsome.common.util.PropertiesHelper;
import com.handsome.siteuser.api.bean.SiteUser;
import com.handsome.siteuser.api.constent.SiteUserConstent;

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
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public ModelAndView main(HttpSession session)
	{
		SiteUser runTimeUser = (SiteUser) session.getAttribute(SessionKeyConstent.SESSION_KEY_OBJ_USER_BEAN);
		String menu = null;
		if (SiteUserConstent.AUTHORITIES_DEPT.equals(runTimeUser.getAuthorities()))
		{
			menu = PropertiesHelper.getProperties("deptAdmin");
		}
		if (SiteUserConstent.AUTHORITIES_EC.equals(runTimeUser.getAuthorities()))
		{
			menu = PropertiesHelper.getProperties("ecAdmin");
		}
		if (SiteUserConstent.AUTHORITIES_SUPER.equals(runTimeUser.getAuthorities()))
		{
			menu = PropertiesHelper.getProperties("superAdmin");
		}
		ModelAndView view = new ModelAndView();
		view.setViewName("/main");
		view.addObject("menu", JSON.parse(menu));
		return view;
	}
}
