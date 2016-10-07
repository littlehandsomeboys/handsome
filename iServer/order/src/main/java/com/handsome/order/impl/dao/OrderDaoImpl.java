package com.handsome.order.impl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.handsome.order.api.bean.Order;
import com.handsome.order.api.dao.OrderDao;

public class OrderDaoImpl extends SqlSessionDaoSupport implements OrderDao
{
	private static Logger log = Logger.getLogger(OrderDaoImpl.class);

	@Override
	public int delete(String id)
	{
		return this.getSqlSession().delete("order.api.Order.delete", id);
	}

	@Override
	public void add(Order o)
	{
		try
		{
			log.debug("begin" + o.toString());
			this.getSqlSession().insert("order.api.Order.create", o);
			log.debug("end");
		}
		catch (Exception e)
		{
			log.error(e.toString(), e);
			System.out.println(e);
		}
	}

	@Override
	public List<Order> list(Order o, Integer offset, Integer rows)
	{
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("userAccount", o.getUserAccount());
		parameterMap.put("offset", offset);
		parameterMap.put("rows", rows);
		List<Order> userList = this.getSqlSession().selectList(
				"order.api.Order.list", parameterMap);
		return userList;
	}

	@Override
	public int count()
	{
		Integer count = this.getSqlSession().selectOne("order.api.Order.count");
		return count;

	}

	@Override
	public void update(Order o)
	{
		this.getSqlSession().update("order.api.Order.update", o);
	}

	@Override
	public Order find(Order o)
	{
		if (StringUtils.isEmpty(o.getOrderId()))
			return new Order();

		return this.getSqlSession().selectOne("order.api.Order.find", o);
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
	{
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
