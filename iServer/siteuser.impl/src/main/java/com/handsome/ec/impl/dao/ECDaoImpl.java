package com.handsome.ec.impl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.handsome.ec.api.bean.EC;
import com.handsome.ec.api.dao.ECDao;

/**
 * 
 * @author dell
 *
 */
public class ECDaoImpl extends SqlSessionDaoSupport implements ECDao
{
	private static Logger log = Logger.getLogger(ECDaoImpl.class);

	public ECDaoImpl()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public int delete(String id)
	{
		return this.getSqlSession().delete("ec.api.EC.delete", id);
	}

	@Override
	public void add(EC ec)
	{
		this.getSqlSession().insert("ec.api.EC.create", ec);
	}

	@Override
	public List<EC> list(EC su, Integer offset, Integer rows)
	{
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("ecName", su.getEcName());
		parameterMap.put("offset", offset);
		parameterMap.put("rows", rows);
		List<EC> ecList = this.getSqlSession().selectList("ec.api.EC.list",
				parameterMap);
		return ecList;
	}

	@Override
	public int count()
	{
		Integer count = this.getSqlSession().selectOne("ec.api.EC.count");
		return count;

	}

	@Override
	public void update(EC ec)
	{
		this.getSqlSession().update("ec.api.EC.update", ec);
	}

	@Override
	public EC find(EC ec)
	{
		if (StringUtils.isEmpty(ec.getEcName())
				&& StringUtils.isEmpty(ec.getEcId()))
			return new EC();
		return this.getSqlSession().selectOne("ec.api.EC.find", ec);
	}

	// @Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
	{
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
