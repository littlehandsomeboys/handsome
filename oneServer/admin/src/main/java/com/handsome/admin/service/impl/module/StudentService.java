package com.handsome.admin.service.impl.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.handsome.admin.ao.common.Page;
import com.handsome.admin.ao.module.classes.ClassAO;
import com.handsome.admin.ao.module.student.StudentAO;
import com.handsome.admin.ao.module.student.StudentSearch;
import com.handsome.admin.ao.module.title.TitleAO;
import com.handsome.admin.dao.api.customized.StudentCustomizedMapper;
import com.handsome.admin.dao.api.generator.StudentMapper;
import com.handsome.admin.service.api.module.IClassService;
import com.handsome.admin.service.api.module.IStudentService;
import com.handsome.admin.service.api.module.ITitleService;

@Service
public class StudentService implements IStudentService {

	private static final Logger LOG = Logger.getLogger(StudentService.class);
	
	@Resource
	private StudentMapper studentMapper;
	
	@Resource
	private StudentCustomizedMapper studentCustomizedMapper;

	@Resource
	private ITitleService titleService;
	
	@Resource
	private IClassService classService;
	
	@Override
	public List<StudentAO> getStudentList(StudentSearch search, Page page) {
		
		List<StudentAO> list = studentCustomizedMapper.getStudentList(search, page);
		
		List<TitleAO> titles = titleService.getTitleList();
		
		List<ClassAO> classRankings = classService.getClassRanking();
		
		Map<String, String> classMap = new HashMap<String, String>(); 
		
		//构建班级缓存对象
		for (ClassAO classAO : classRankings) {
			classMap.put(classAO.getId(), classAO.getCampName());
		}
		
		if (null != list) {
			for (StudentAO student : list) {
				//设置班级阵营
				student.setCampName(classMap.get(student.getClassId()));
				for (TitleAO title : titles) {
					//title默认按照pointlimit降序
					if(student.getPoint() >= title.getLimitPoint()) {
						//设置学生称号
						student.setTitleId(title.getId());
						student.setTitleName(title.getName());
						break;
					}
				}
			}
		}
		return list;
	}
	
}
