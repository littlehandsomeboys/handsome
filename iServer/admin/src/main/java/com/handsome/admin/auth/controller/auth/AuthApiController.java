package com.handsome.admin.auth.controller.auth;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.handsome.admin.common.bean.ResponseObject;
import com.handsome.admin.common.util.SessionInitHelper;
import com.handsome.admin.constent.SessionKeyConstent;
import com.handsome.siteuser.api.bean.SiteUser;
import com.handsome.siteuser.api.constent.SiteUserConstent;
import com.handsome.siteuser.api.service.SiteUserService;

/**
 * 
 * @author dell
 *
 */
@Api("权限管理接口")
@RestController
@RequestMapping("/auth/api")
public class AuthApiController
{

	@Autowired
	@Qualifier(value = "siteUserServiceImpl")
	private SiteUserService siteUserService;

	@ApiOperation("新用户注册接口")
	@RequestMapping(value = "/signup.do", method = RequestMethod.POST)
	public @ResponseBody String signup(
			@ApiParam(value = "用户名", required = true) @RequestParam("username") String userName,
			@ApiParam(value = "密码", required = true) @RequestParam("password") String password)
	{
		ResponseObject res = new ResponseObject();
		try
		{
			SiteUser su = new SiteUser();
			su.setAccount(userName);
			su.setPassword(password);
			// TODO:添加企业
			siteUserService.createSiteUser(su);
		}
		catch (Exception e)
		{
			res.setCode(1);
			res.setError(e.getMessage());
		}
		return JSON.toJSONString(res);
	}

	@ApiOperation("用户登录接口")
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public @ResponseBody String login(
			@ApiParam(value = "用户名", required = true) @RequestParam("username") String userName,
			@ApiParam(value = "密码", required = true) @RequestParam("password") String password,
			HttpServletRequest request)
	{
		ResponseObject res = new ResponseObject();
		if (StringUtils.isEmpty(userName))
		{
			res.setCode(2);
			res.setError("登录失败，用户名为空！");
			return JSON.toJSONString(res);
		}
		
		if (StringUtils.isEmpty(password))
		{
			res.setCode(3);
			res.setError("登录失败，密码为空！");
			return JSON.toJSONString(res);
		}
		
		try
		{
			SiteUser su = siteUserService.getSiteUserByUserName(userName);
			if (StringUtils.isNotEmpty(password) && null != su
					&& password.equals(su.getPassword()))
			{
				SessionInitHelper.setSessionAttribute(request.getSession(),SessionKeyConstent.SESSION_KEY_OBJ_USER_BEAN, su);
				res.setCode(0);
				res.setData("成功");
			}
			else
			{
				res.setCode(1);
				res.setError("登录失败，用户名或密码不存在！");
			}
		}
		catch (Exception e)
		{
			res.setCode(1);
			res.setError(e.getMessage());
		}
		return JSON.toJSONString(res);
	}
	
	@ApiOperation("权限选择下拉菜单")
	@RequestMapping(value = "/selectAuthorities.do", method = RequestMethod.GET)
	public @ResponseBody Object selectAuthorities(HttpServletRequest request, HttpSession session)
	{
		SiteUser runTimeUser = (SiteUser) session.getAttribute(SessionKeyConstent.SESSION_KEY_OBJ_USER_BEAN);
		String authorities = "";
		if (SiteUserConstent.AUTHORITIES_SUPER.equals(runTimeUser.getAuthorities()))
		{
			authorities = "[{\"id\":1,\"text\":\"超级管理员\"},{\"id\":2,\"text\":\"校长\"},{\"id\":3,\"text\":\"老师\"}]";
		}
		else
		{
			authorities = "[{\"id\":2,\"text\":\"校长\"},{\"id\":3,\"text\":\"老师\"}]";
		}
		
		return JSON.parse(authorities);
	}

}
