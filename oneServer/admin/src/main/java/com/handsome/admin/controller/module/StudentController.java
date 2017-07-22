package com.handsome.admin.controller.module;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.handsome.admin.ao.module.student.StudentAO;
import com.handsome.admin.ao.module.student.StudentSearch;
import com.handsome.admin.service.api.module.IStudentService;

@Controller
@RequestMapping(value="/app/student")
public class StudentController {

	@Resource
	private IStudentService studentService;
	
	@RequestMapping(value="/getStudentList", method={RequestMethod.GET})
	@ResponseBody
	public Object getStudentList(StudentSearch search) {
		
		List<StudentAO> list = studentService.getStudentList(search);
		
		return JSON.toJSONString(list);
	}
	
}
