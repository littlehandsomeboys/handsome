package com.handsome.admin.controller.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.handsome.admin.ao.common.Page;
import com.handsome.admin.ao.common.SelectDTO;
import com.handsome.admin.ao.module.school.SchoolAO;
import com.handsome.admin.ao.module.student.StudentAO;
import com.handsome.admin.ao.module.student.StudentSearch;
import com.handsome.admin.service.api.module.IClassService;
import com.handsome.admin.service.api.module.ISchoolService;
import com.handsome.admin.service.api.module.IStudentService;

@Controller
@RequestMapping(value="/app/student")
public class StudentController {

	@Resource
	private IStudentService studentService;
	
	@Resource
	private ISchoolService schoolService;
	
	@Resource
	private IClassService classService;
	
	@RequestMapping(value="/studentlist", method={RequestMethod.GET})
	public ModelAndView getStudentList() {
		SchoolAO school = schoolService.getSchoolInfo();
		ModelAndView mv = new ModelAndView("app/student/studentlist");
		mv.addObject("schoolName", school.getName());
		return mv;
	}
	
	@RequestMapping(value="/getStudentList", method={RequestMethod.GET})
	@ResponseBody
	public Object getStudentList(StudentSearch search, Page page) {
		page.setPageNo(1);//默认第一页
		page.setLength(50);//每页50条
		List<StudentAO> list = studentService.getStudentList(search, page);
		return JSON.toJSONString(list);
	}
	
}
