package com.handsome.admin.service.impl.module;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.handsome.admin.ao.module.title.TitleAO;
import com.handsome.admin.dao.api.customized.TitleCustomizedMapper;
import com.handsome.admin.dao.api.generator.TitleMapper;
import com.handsome.admin.service.api.module.ITitleService;

@Service
public class TitleService implements ITitleService{

	@Resource
	private TitleMapper titleMapper;
	
	@Resource
	private TitleCustomizedMapper titleCustomizedMapper;
	
	@Override
	public List<TitleAO> getTitleList() {
		List<TitleAO> titles = titleCustomizedMapper.getTitles();
		return titles;
	}

}
