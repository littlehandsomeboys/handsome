package com.handsome.admin.service.api.module;

import java.util.List;

import com.handsome.admin.ao.common.Page;
import com.handsome.admin.ao.module.student.StudentAO;
import com.handsome.admin.ao.module.student.StudentSearch;

public interface IStudentService {

	List<StudentAO> getStudentList(StudentSearch search, Page page);
	
}
