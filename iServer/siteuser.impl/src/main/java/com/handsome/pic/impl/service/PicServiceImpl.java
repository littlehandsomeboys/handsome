package com.handsome.pic.impl.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.handsome.common.bean.PageInfo;
import com.handsome.common.util.UUIDTool;
import com.handsome.pic.api.bean.Pic;
import com.handsome.pic.api.dao.PicDao;
import com.handsome.pic.api.service.PicService;

//@Service(value = "siteUserServiceImpl")
public class PicServiceImpl implements PicService
{

	// @Autowired
	// @Qualifier(value = "siteUserDaoImpl")
	private PicDao picDao;

	@Override
	public void createPic(Pic pic)
	{
		pic.setPicId(UUIDTool.getUUID32());
		pic.setCreateDate(new Date());

		picDao.add(pic);
	}

	@Override
	public void updatePic(Pic pic)
	{
		Pic queryPic = new Pic();
		queryPic = picDao.find(pic);
		if (null != pic)
		{
			queryPic.setUpdateDate(new Date());
			queryPic.setDir(pic.getDir());
			queryPic.setUrl(pic.getUrl());
			picDao.update(queryPic);
		}
	}

	@Override
	public Pic getPic(Pic pic)
	{
		if (StringUtils.isEmpty(pic.getPicId())
				&& StringUtils.isEmpty(pic.getDir())
				&& StringUtils.isEmpty(pic.getUrl()))
		{
			return new Pic();
		}
		return picDao.find(pic);
	}

	@Override
	public List<Pic> getPicList(Pic pic, PageInfo pi)
	{
		int offset;
		int rows;
		if (null == pi)
		{
			offset = 0;
			rows = picDao.count();
		}
		else
		{
			offset = pi.getPageNo() * pi.getPageSize();
			rows = pi.getPageSize();
		}
		return picDao.list(pic, offset, rows);
	}

	@Override
	public int countPic()
	{
		return picDao.count();
	}

	@Override
	public int deletePic(String picId)
	{
		return picDao.delete(picId);
	}

	public PicDao getPicDao()
	{
		return picDao;
	}

	public void setPicDao(PicDao picDao)
	{
		this.picDao = picDao;
	}

}
