package com.handsome.admin.service.impl.module;

import java.util.ArrayList;
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
		Map<Integer, List<TitleAO>> pointCountMap = new HashMap<Integer, List<TitleAO>>();
		for (TitleAO title : titles) {
			if (pointCountMap.containsKey(title.getLimitPoint())) {
				pointCountMap.get(title.getLimitPoint()).add(title);
			}
			else {
				List<TitleAO> ts = new ArrayList<TitleAO>();
				ts.add(title);
				pointCountMap.put(title.getLimitPoint(), ts);
			}
		}
		
		List<ClassAO> classRankings = classService.getClassRanking();
		
		Map<String, String> classCampIdMap = new HashMap<String, String>(); 
		Map<String, String> classCampNameMap = new HashMap<String, String>(); 
		//构建班级缓存对象
		for (ClassAO classAO : classRankings) {
			classCampIdMap.put(classAO.getId(), classAO.getCampId());
			classCampNameMap.put(classAO.getId(), classAO.getCampName());
		}
		
		if (null != list) {
			for (StudentAO student : list) {
				//设置班级阵营
				student.setCampId(classCampIdMap.get(student.getClassId()));
				student.setCampName(classCampNameMap.get(student.getClassId()));
				if (null != titles) {
					for (TitleAO title : titles) {
						//title已经默认按照pointlimit降序了
						if(student.getPoint() >= title.getLimitPoint()) {
							//设置学生称号
							List<TitleAO> radoms = pointCountMap.get(title.getLimitPoint());
							//TODO:如果多个分值相同，随机取值
							if (radoms.size() > 1) {
								//产生算子 学号+名字+英文名
								String key = student.getCode()+student.getName()+student.getEnglishName();
								int hashCode = key.hashCode();
								//取余
								int mod = hashCode%radoms.size();
								TitleAO t = radoms.get(Math.abs(mod));
								student.setTitleId(t.getId());
								student.setTitleName(t.getName());
							}
							else {
								student.setTitleId(title.getId());
								student.setTitleName(title.getName());
							}
							break;
						}
					}
				}
			}
		}
		return list;
	}
	
}
