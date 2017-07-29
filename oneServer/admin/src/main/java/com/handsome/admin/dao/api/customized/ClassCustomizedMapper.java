package com.handsome.admin.dao.api.customized;

import java.util.List;

import com.handsome.admin.ao.common.SelectDTO;
import com.handsome.admin.ao.module.classes.ClassAO;

public interface ClassCustomizedMapper {

	List<SelectDTO> selectClass();
	
	List<ClassAO> getClassRanking();
}
