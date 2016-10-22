package com.handsome.pic.impl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.handsome.ec.api.bean.EC;
import com.handsome.ec.api.dao.ECDao;
import com.handsome.pic.api.bean.Pic;
import com.handsome.pic.api.dao.PicDao;

/**
 * 
 * @author dell
 *
 */
public class PicDaoImpl extends SqlSessionDaoSupport implements
		PicDao
{
	private static Logger log = Logger.getLogger(PicDaoImpl.class);

	public PicDaoImpl()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public int delete(String id)
	{
		return this.getSqlSession().delete("pic.api.Pic.delete", id);
	}

	@Override
	public void add(Pic pic)
	{
		try
		{
			log.debug("begin" + pic.toString());
			this.getSqlSession().insert("pic.api.Pic.create", pic);
			log.debug("end");
		}
		catch (Exception e)
		{
			log.error(e.toString(), e);
			System.out.println(e);
		}
	}

	@Override
	public List<Pic> list(Pic pic, Integer offset, Integer rows)
	{
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("dir", pic.getDir());
		parameterMap.put("url", pic.getUrl());
		parameterMap.put("offset", offset);
		parameterMap.put("rows", rows);
		List<Pic> picList = this.getSqlSession().selectList(
				"pic.api.Pic.list", parameterMap);
		return picList;
	}

	@Override
	public int count()
	{
		Integer count = this.getSqlSession().selectOne(
				"pic.api.Pic.count");
		return count;

	}

	@Override
	public void update(Pic pic)
	{
		this.getSqlSession().update("pic.api.Pic.update", pic);
	}

	@Override
	public Pic find(Pic pic)
	{
		if (StringUtils.isEmpty(pic.getPicId()))
			return new Pic();

		return this.getSqlSession().selectOne("pic.api.Pic.find", pic);
	}

	// @Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
	{
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
