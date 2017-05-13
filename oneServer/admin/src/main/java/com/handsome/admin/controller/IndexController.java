/**
 * 
 */
package com.handsome.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author dell
 *
 */
@Controller
@RequestMapping(value="/app")
public class IndexController {

	@RequestMapping(value="/index", method={RequestMethod.GET,RequestMethod.POST})
	public String index() {
		return "app/index";
	}
	
}
