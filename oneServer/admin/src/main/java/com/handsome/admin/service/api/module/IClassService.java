package com.handsome.admin.service.api.module;

import java.util.List;

import com.handsome.admin.ao.common.SelectDTO;
import com.handsome.admin.ao.module.classes.ClassAO;

public interface IClassService {
	
	List<SelectDTO> selectClass();

	List<ClassAO> getClassRanking();
	
}
