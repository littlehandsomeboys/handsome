package com.handsome.admin.service.impl.module;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.handsome.admin.ao.common.Page;
import com.handsome.admin.ao.module.student.StudentAO;
import com.handsome.admin.ao.module.student.StudentSearch;
import com.handsome.admin.dao.api.customized.StudentCustomizedMapper;
import com.handsome.admin.dao.api.generator.StudentMapper;
import com.handsome.admin.service.api.module.IStudentService;

@Service
public class StudentService implements IStudentService {

	private static final Logger LOG = Logger.getLogger(StudentService.class);
	
	@Resource
	private StudentMapper studentMapper;
	
	@Resource
	private StudentCustomizedMapper studentCustomizedMapper;

	@Override
	public List<StudentAO> getStudentList(StudentSearch search, Page page) {
		
		List<StudentAO> list = studentCustomizedMapper.getStudentList(search, page);
		
		return list;
	}
	
}
