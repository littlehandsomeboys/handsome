package com.handsome.product.impl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.handsome.product.api.bean.Product;
import com.handsome.product.api.dao.ProductDao;

public class ProductDaoImpl extends SqlSessionDaoSupport implements ProductDao
{
	private static Logger log = Logger.getLogger(ProductDaoImpl.class);

	@Override
	public int delete(String id)
	{
		return this.getSqlSession().delete("product.api.Product.delete", id);
	}

	@Override
	public void add(Product p)
	{
		try
		{
			log.debug("begin" + p.toString());
			this.getSqlSession().insert("product.api.Product.create", p);
			log.debug("end");
		}
		catch (Exception e)
		{
			log.error(e.toString(), e);
			System.out.println(e);
		}
	}

	@Override
	public List<Product> list(Product p, Integer offset, Integer rows)
	{
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("productName", p.getProductName());
		parameterMap.put("offset", offset);
		parameterMap.put("rows", rows);
		List<Product> userList = this.getSqlSession().selectList(
				"product.api.Product.list", parameterMap);
		return userList;
	}

	@Override
	public int count()
	{
		Integer count = this.getSqlSession().selectOne("product.api.Product.count");
		return count;

	}

	@Override
	public void update(Product p)
	{
		this.getSqlSession().update("product.api.Product.update", p);
	}

	@Override
	public Product find(Product p)
	{
		if (StringUtils.isEmpty(p.getProductName())
				&& StringUtils.isEmpty(p.getProductId()))
			return new Product();

		return this.getSqlSession().selectOne("product.api.Product.find", p);
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
	{
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
