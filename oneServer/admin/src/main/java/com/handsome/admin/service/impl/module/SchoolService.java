package com.handsome.admin.service.impl.module;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.handsome.admin.ao.bean.School;
import com.handsome.admin.ao.bean.SchoolExample;
import com.handsome.admin.ao.module.school.SchoolAO;
import com.handsome.admin.dao.api.generator.SchoolMapper;
import com.handsome.admin.service.api.module.ISchoolService;

@Service
public class SchoolService implements ISchoolService{

	@Resource
	private SchoolMapper schoolMapper;
	
	@Override
	public SchoolAO getSchoolInfo() {
		
		SchoolExample ae = new SchoolExample();
		SchoolExample.Criteria sca = ae.createCriteria();
		sca.andIdEqualTo("1");
		List<School> s = schoolMapper.selectByExample(ae);
		SchoolAO scao = new SchoolAO();
		if (!CollectionUtils.isEmpty(s)) {
			BeanUtils.copyProperties(s.get(0), scao);
		}
		return scao;
	}

}
