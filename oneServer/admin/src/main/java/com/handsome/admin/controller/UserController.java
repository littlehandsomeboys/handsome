/**
 * 
 */
package com.handsome.admin.controller;

import java.util.List;

import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.handsome.admin.ao.UserAO;
import com.handsome.admin.service.api.UserService;
import com.handsome.common.bean.ServiceResult;

/**
 * @author dell
 *
 */
@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/findUser.do", method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String findUser(String account) {
		UserAO userAO = userService.findUser(account);
		return JSON.toJSONString(userAO);
	}
	
	@RequestMapping(value="/queryUsers.do", method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String queryUsers(UserAO userAO) {
		List<UserAO> userAOs = userService.queryUsers(userAO);
		ServiceResult sr = new ServiceResult(userAOs);
		sr.setDraw(1);
		sr.setRecordsFiltered(2);
		sr.setRecordsTotal(2);
		return Json.toJson(sr);
	}
	
}
