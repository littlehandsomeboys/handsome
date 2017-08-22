package com.handsome.admin.service.impl.module;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.handsome.admin.ao.bean.CcLl;
import com.handsome.admin.dao.api.generator.CcLlMapper;
import com.handsome.admin.service.api.module.ICcLlService;

@Service
public class CcLlService implements ICcLlService {

	@Resource
	private CcLlMapper ccLlMapper;
	
	@Override
	public void insertDate(CcLl ccll) {
		ccLlMapper.insert(ccll);
	}

}
