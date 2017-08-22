package com.handsome.admin.controller.module;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.handsome.admin.ao.bean.StuCardRel;
import com.handsome.admin.ao.common.Page;
import com.handsome.admin.ao.common.SelectDTO;
import com.handsome.admin.ao.module.school.SchoolAO;
import com.handsome.admin.ao.module.student.StuCardRelAO;
import com.handsome.admin.ao.module.student.StudentAO;
import com.handsome.admin.ao.module.student.StudentSearch;
import com.handsome.admin.service.api.module.IClassService;
import com.handsome.admin.service.api.module.IPointcardService;
import com.handsome.admin.service.api.module.IStudentService;

@Controller
@RequestMapping(value="/app/teacher")
public class TeacherController {
	
	@Resource
	private IStudentService studentService;
	
	@Resource
	private IClassService classService;
	
	@Resource
	private IPointcardService pointcardService;
	
	@RequestMapping(value="/studentclasslist", method={RequestMethod.GET})
	public ModelAndView student_class_list() {
		ModelAndView mv = new ModelAndView("app/teacher/studentpoint");
		List<SelectDTO> classList = classService.selectClass();
		mv.addObject("classList", classList);
		return mv;
	}	
	
	@RequestMapping(value="/studentlist", method={RequestMethod.GET})
	public ModelAndView freshHonorroll(String classId) {
		ModelAndView mv = new ModelAndView("app/teacher/studentpoint1");
		if (StringUtils.isEmpty(classId) || "0".equals(classId)) {
			return mv;
		}
		List<StudentAO> studentList = studentService.getClassStudents(classId);
		mv.addObject("studentList", studentList);
		return mv;
	}
	
	@RequestMapping(value="/getlastrecords", method={RequestMethod.GET})
	public ModelAndView getlastrecords(String studentId, Page page) {
		page.setPageNo(1);//默认第一页
		page.setLength(10);//每页10条
		ModelAndView mv = new ModelAndView("app/teacher/lastrecords");
		List<StuCardRelAO> studentPoints = studentService.getStuCardRel(studentId, page);
		mv.addObject("lastrecords", studentPoints);
		return mv;
	}
	
	@RequestMapping(value="/addrecord", method={RequestMethod.GET})
	public ModelAndView addrecord(String studentId) {
		ModelAndView mv = new ModelAndView("app/teacher/addrecord");
		List<SelectDTO> cards = pointcardService.selectPointCards();
		mv.addObject("cards", cards);
		mv.addObject("studentId", studentId);
		return mv;
	}
	
	@RequestMapping(value="/submit", method={RequestMethod.POST})
	@ResponseBody
	public Object submit(Integer num, String studentId, String cardId, String remark) {
		studentService.addStuCardRel(num, studentId, cardId, remark);
		return "ok";
	}
	
	@RequestMapping(value="/deleteStuCardRel", method={RequestMethod.POST})
	@ResponseBody
	public Object deleteStuCardRel(String id) {
		studentService.deleteStuCardRel(id);
		return "ok";
	}
}
