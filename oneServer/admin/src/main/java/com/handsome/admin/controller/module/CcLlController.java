package com.handsome.admin.controller.module;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.handsome.admin.ao.bean.CcLl;
import com.handsome.admin.service.api.module.ICcLlService;

@Controller
@RequestMapping(value="/xhw")
public class CcLlController {
	@Resource
	private ICcLlService ccLlService;
	
	@RequestMapping(value="/feedback", method={RequestMethod.GET})
	public ModelAndView feedback() {
		ModelAndView mv = new ModelAndView("app/ccll/feedback");
		return mv;
	}
	
	@RequestMapping(value="/submit", method={RequestMethod.POST})
	@ResponseBody
	public Object submit(CcLl ccll) {

		ccLlService.insertDate(ccll);
		
		return true;
	}
}
