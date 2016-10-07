package com.handsome.producttype.impl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.handsome.producttype.api.bean.ProductType;
import com.handsome.producttype.api.dao.ProductTypeDao;

public class ProductTypeDaoImpl extends SqlSessionDaoSupport implements ProductTypeDao
{
	private static Logger log = Logger.getLogger(ProductTypeDaoImpl.class);

	@Override
	public int delete(String id)
	{
		return this.getSqlSession().delete("producttype.api.ProductType.delete", id);
	}

	@Override
	public void add(ProductType pt)
	{
		try
		{
			log.debug("begin" + pt.toString());
			this.getSqlSession().insert("producttype.api.ProductType.create", pt);
			log.debug("end");
		}
		catch (Exception e)
		{
			log.error(e.toString(), e);
			System.out.println(e);
		}
	}

	@Override
	public List<ProductType> list(ProductType pt, Integer offset, Integer rows)
	{
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("productTypeName", pt.getProductTypeName());
		parameterMap.put("offset", offset);
		parameterMap.put("rows", rows);
		List<ProductType> userList = this.getSqlSession().selectList(
				"producttype.api.ProductType.list", parameterMap);
		return userList;
	}

	@Override
	public int count()
	{
		Integer count = this.getSqlSession().selectOne("producttype.api.ProductType.count");
		return count;

	}

	@Override
	public void update(ProductType pt)
	{
		this.getSqlSession().update("producttype.api.ProductType.update", pt);
	}

	@Override
	public ProductType find(ProductType pt)
	{
		if (StringUtils.isEmpty(pt.getProductTypeName())
				&& StringUtils.isEmpty(pt.getProductTypeId()))
			return new ProductType();

		return this.getSqlSession().selectOne("producttype.api.ProductType.find", pt);
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
	{
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
