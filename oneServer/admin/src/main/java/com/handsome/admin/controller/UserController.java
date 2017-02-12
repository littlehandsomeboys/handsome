/**
 * 
 */
package com.handsome.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.handsome.admin.ao.UserAO;
import com.handsome.admin.service.api.UserService;

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
	
}
