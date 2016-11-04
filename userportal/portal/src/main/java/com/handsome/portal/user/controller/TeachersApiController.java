/*
 * 
 */
package com.handsome.portal.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.handsome.common.bean.PageInfo;
import com.handsome.portal.user.bean.Teacher;
import com.handsome.siteuser.api.bean.SiteUser;
import com.handsome.siteuser.api.constent.SiteUserConstent;
import com.handsome.siteuser.api.service.SiteUserService;

/**
 * 
 * @author dell
 *
 */
@Api("教师接口")
@RestController
@RequestMapping("/teacher/api")
public class TeachersApiController
{

	@Autowired
	@Qualifier(value = "siteUserService")
	private SiteUserService siteUserService;

	public TeachersApiController()
	{
		// TODO Auto-generated constructor stub
	}

	@ApiOperation("教师列表查询接口")
	@RequestMapping(value = "/teacherList.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody String teacherList(@ModelAttribute Teacher teacher,
			@RequestParam String pageNo, @RequestParam String pageSize,
			HttpServletRequest request, HttpServletResponse response)
	{
		SiteUser su = new SiteUser();
		if (StringUtils.isNotEmpty(teacher.getEcName()))
		{
			su.setEcName(teacher.getEcName());
		}
		if (StringUtils.isNotEmpty(teacher.getReserve5()))
		{
			su.setReserve5(teacher.getReserve5());
		}
		PageInfo pi = new PageInfo();
		pi.setPageNo(NumberUtils.toInt(pageNo));
		pi.setPageSize(NumberUtils.toInt(pageSize));

		List<SiteUser> sus = siteUserService.getSiteUserList(su, pi, SiteUserConstent.AUTHORITIES_EC);
		JSONArray rows = new JSONArray();
		for (SiteUser siteUser : sus)
		{
			JSONObject user = new JSONObject();
			user.put("account", siteUser.getAccount());
			user.put("authorities", siteUser.getAuthorities());
			user.put("createDate", siteUser.getCreateDate());
			user.put("ecName", siteUser.getEcName());
			user.put("enabled", siteUser.getEnabled());
			user.put("reserve0", siteUser.getReserve0());
			user.put("reserve1", siteUser.getReserve1());
			user.put("reserve2", siteUser.getReserve2());
			user.put("reserve3", siteUser.getReserve3());
			user.put("reserve4", siteUser.getReserve4());
			user.put("reserve5", siteUser.getReserve5());
			user.put("reserve6", siteUser.getReserve6());
			user.put("reserve7", siteUser.getReserve7());
			user.put("reserve8", siteUser.getReserve8());
			user.put("reserve9", siteUser.getReserve9());
			rows.add(user);
		}

		Integer total = siteUserService.countSiteUser();

		JSONObject res = new JSONObject();
		res.put("total", total);
		res.put("rows", rows);
		res.put("result", "0");
		res.put("mes", "ok");
		return JSON.toJSONString(res);
	}

	@ApiOperation("教师列表查询接口")
	@RequestMapping(value = "/teacherDetail.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody String teacherDetail(@ModelAttribute Teacher teacher,
			HttpServletRequest request, HttpServletResponse response)
	{
		JSONObject res = new JSONObject();
		if (null == teacher)
		{
			res.put("result", "1");
			res.put("mes", "param empty");
			return JSON.toJSONString(res);
		}

		SiteUser siteUser = siteUserService.getSiteUserByUserName(teacher
				.getAccount());

		JSONObject user = new JSONObject();
		user.put("account", siteUser.getAccount());
		user.put("authorities", siteUser.getAuthorities());
		user.put("createDate", siteUser.getCreateDate());
		user.put("ecName", siteUser.getEcName());
		user.put("enabled", siteUser.getEnabled());
		user.put("reserve0", siteUser.getReserve0());
		user.put("reserve1", siteUser.getReserve1());
		user.put("reserve2", siteUser.getReserve2());
		user.put("reserve3", siteUser.getReserve3());
		user.put("reserve4", siteUser.getReserve4());
		user.put("reserve5", siteUser.getReserve5());
		user.put("reserve6", siteUser.getReserve6());
		user.put("reserve7", siteUser.getReserve7());
		user.put("reserve8", siteUser.getReserve8());
		user.put("reserve9", siteUser.getReserve9());

		res.put("obj", user);
		res.put("result", "0");
		res.put("mes", "ok");
		return JSON.toJSONString(res);
	}

}
