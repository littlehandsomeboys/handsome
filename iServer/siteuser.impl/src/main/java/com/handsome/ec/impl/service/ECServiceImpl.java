package com.handsome.ec.impl.service;

import java.util.Date;
import java.util.List;

import com.handsome.common.bean.PageInfo;
import com.handsome.common.util.UUIDTool;
import com.handsome.ec.api.bean.EC;
import com.handsome.ec.api.dao.ECDao;
import com.handsome.ec.api.service.ECService;

//@Service(value = "siteUserServiceImpl")
public class ECServiceImpl implements ECService
{

	// @Autowired
	// @Qualifier(value = "siteUserDaoImpl")
	private ECDao ecDao;

	@Override
	public void createEC(EC ec)
	{
		ec.setEcName(ec.getEcName());
		ec.setEcId(UUIDTool.getUUID32());
		ec.setCreateDate(new Date());

		ecDao.add(ec);
	}

	@Override
	public void updateEC(EC ec)
	{
		ecDao.update(ec);
	}
	
	@Override
	public EC getECById(String ecId)
	{
		EC ec = new EC();
		ec.setEcId(ecId);
		return ecDao.find(ec);
	}

	@Override
	public EC getECByECName(String ecName)
	{
		EC ec = new EC();
		ec.setEcName(ecName);
		// TODO Auto-generated method stub
		return ecDao.find(ec);
	}

	@Override
	public List<EC> getECList(EC ec, PageInfo pi)
	{
		int offset;
		int rows;
		if (null == pi)
		{
			offset = 0;
			rows = ecDao.count();
		}
		else
		{
			offset = pi.getPageNo() * pi.getPageSize();
			rows = pi.getPageSize();
		}
		return ecDao.list(ec, offset, rows);
	}

	@Override
	public int countEC()
	{
		return ecDao.count();
	}
	
	@Override
	public int deleteEC(String ecId)
	{
		return ecDao.delete(ecId);
	}

	public ECDao getEcDao()
	{
		return ecDao;
	}

	public void setEcDao(ECDao ecDao)
	{
		this.ecDao = ecDao;
	}


}
