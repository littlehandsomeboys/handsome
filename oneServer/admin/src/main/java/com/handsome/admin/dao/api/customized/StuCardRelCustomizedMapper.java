package com.handsome.admin.dao.api.customized;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.handsome.admin.ao.bean.StuCardRel;
import com.handsome.admin.ao.common.Page;
import com.handsome.admin.ao.module.student.StuCardRelAO;

public interface StuCardRelCustomizedMapper {
	
	List<StuCardRelAO> getStuCardRel(@Param("studentId") String studentId, @Param("page") Page page);
}
