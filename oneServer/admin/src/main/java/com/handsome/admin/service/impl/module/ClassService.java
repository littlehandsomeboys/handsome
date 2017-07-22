package com.handsome.admin.service.impl.module;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.handsome.admin.ao.common.SelectDTO;
import com.handsome.admin.dao.api.customized.ClassCustomizedMapper;
import com.handsome.admin.service.api.module.IClassService;

@Service
public class ClassService implements IClassService {

	@Resource
	private ClassCustomizedMapper classCustomizedMapper;
	
	@Override
	public List<SelectDTO> selectClass() {
		List<SelectDTO> list = classCustomizedMapper.selectClass();
		return list;
	}

}
