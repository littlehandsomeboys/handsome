package com.handsome.admin.controller.module;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.handsome.admin.ao.common.SelectDTO;
import com.handsome.admin.service.api.module.IClassService;

@Controller
@RequestMapping(value="/app/class")
public class ClassController {

	@Resource
	private IClassService classService;
	
	@RequestMapping(value="/selectClass", method={RequestMethod.GET})
	@ResponseBody
	public Object selectClass() {
		
		List<SelectDTO> list = classService.selectClass();
		
		return JSON.toJSONString(list);
	}
	
}
