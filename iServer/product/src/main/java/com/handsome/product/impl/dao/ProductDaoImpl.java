package com.handsome.product.impl.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.handsome.product.api.bean.Product;
import com.handsome.product.api.dao.ProductDao;

public class ProductDaoImpl extends SqlSessionDaoSupport implements ProductDao
{

	public ProductDaoImpl()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addProduct(Product product)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
	{
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
