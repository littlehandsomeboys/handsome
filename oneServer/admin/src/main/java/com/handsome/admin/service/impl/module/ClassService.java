package com.handsome.admin.service.impl.module;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.handsome.admin.ao.common.SelectDTO;
import com.handsome.admin.ao.module.camp.CampAO;
import com.handsome.admin.ao.module.classes.ClassAO;
import com.handsome.admin.dao.api.customized.CampCustomizedMapper;
import com.handsome.admin.dao.api.customized.ClassCustomizedMapper;
import com.handsome.admin.service.api.module.IClassService;

@Service
public class ClassService implements IClassService {

	@Resource
	private ClassCustomizedMapper classCustomizedMapper;
	
	@Resource
	private CampCustomizedMapper campCustomizedMapper;
	
	@Override
	public List<SelectDTO> selectClass() {
		List<SelectDTO> list = classCustomizedMapper.selectClass();
		return list;
	}

	@Override
	public List<ClassAO> getClassRanking() {
		
		List<ClassAO> classRankings = classCustomizedMapper.getClassRanking();
		List<CampAO> camps = campCustomizedMapper.getCampsList();
		//设置班级阵营
		if (null != camps) {
			for (int i=0 ; i < camps.size() ; i++) {
				if (classRankings.size() > i) {
					classRankings.get(i).setCampId(camps.get(i).getId());
					classRankings.get(i).setCampName(camps.get(i).getName());
				}
			}
		}
		
		return classRankings;
	}

	
	
}
