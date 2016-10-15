package com.handsome.admin.siteuser.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.handsome.common.bean.PageInfo;
import com.handsome.siteuser.api.bean.SiteUser;
import com.handsome.siteuser.api.service.SiteUserService;

/**
 * 
 * @author dell
 *
 */
@Api("权限管理接口")
@RestController
@RequestMapping("/siteuser/api")
public class SiteUserApiController
{

	@Autowired
	@Qualifier(value = "siteUserServiceImpl")
	private SiteUserService siteUserService;

	@ApiOperation("新用户注册接口")
	@RequestMapping(value = "/querySiteUsers.do", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
	public @ResponseBody String querySiteUsers(HttpServletRequest request)
	{
		SiteUser su = new SiteUser();

		su.setAccount(request.getParameter("account"));
		su.setReserve5(request.getParameter("reserve5"));
		su.setEcName("".equals(request.getParameter("ecName")) ? null : request
				.getParameter("ecName"));

		PageInfo pi = new PageInfo();
		pi.setPageNo(NumberUtils.toInt(request.getParameter("page")));
		pi.setPageSize(NumberUtils.toInt(request.getParameter("rows")));
		List<SiteUser> sus = siteUserService.getSiteUserList(su, null);
		sus = siteUserService.getSiteUserList(su, pi);
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

		return res.toJSONString();

	}

}
