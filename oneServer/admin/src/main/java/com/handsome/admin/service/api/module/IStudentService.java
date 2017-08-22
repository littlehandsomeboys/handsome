package com.handsome.admin.service.api.module;

import java.util.List;

import com.handsome.admin.ao.bean.StuCardRel;
import com.handsome.admin.ao.common.Page;
import com.handsome.admin.ao.module.student.StuCardRelAO;
import com.handsome.admin.ao.module.student.StudentAO;
import com.handsome.admin.ao.module.student.StudentSearch;

public interface IStudentService {

	List<StudentAO> getStudentList(StudentSearch search, Page page);
	
	List<StudentAO> getClassStudents(String classId);
	
	List<StuCardRelAO> getStuCardRel(String sdudentId, Page page);
	
	void addStuCardRel(Integer num, String studentId, String cardId, String remark);
	
	void deleteStuCardRel(String id);
}
