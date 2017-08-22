package com.handsome.admin.service.impl.module;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.handsome.admin.ao.common.SelectDTO;
import com.handsome.admin.dao.api.customized.PointcardCustomizedMapper;
import com.handsome.admin.dao.api.generator.PointcardMapper;
import com.handsome.admin.service.api.module.IPointcardService;

@Service
public class PointcardService implements IPointcardService{

	@Resource
	private PointcardCustomizedMapper pointcardCustomizedMapper;
	
	@Override
	public List<SelectDTO> selectPointCards() {
		return pointcardCustomizedMapper.selectPointCards();
	}

}
