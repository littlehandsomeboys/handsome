package com.handsome.admin.dao.api.customized;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.handsome.admin.ao.common.Page;
import com.handsome.admin.ao.module.student.StudentAO;
import com.handsome.admin.ao.module.student.StudentSearch;

public interface StudentCustomizedMapper {

	List<StudentAO> getStudentList(@Param("search") StudentSearch search, @Param("page") Page page);
	
}
