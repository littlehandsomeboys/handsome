package com.handsome.order.impl.service;

import java.util.Date;
import java.util.List;

import com.handsome.common.bean.PageInfo;
import com.handsome.common.util.UUIDTool;
import com.handsome.order.api.bean.Order;
import com.handsome.order.api.dao.OrderDao;
import com.handsome.order.api.service.OrderService;

/**
 * Hello world!
 *
 */
public class OrderServiceImpl implements OrderService
{
	private OrderDao orderDao;

	@Override
	public void createProduct(Order o)
	{
		o.setOrderId(UUIDTool.getUUID32());
		o.setCreateDate(new Date());

		orderDao.add(o);
	}

	@Override
	public void updateOrder(Order o)
	{
		o.setOrderId(UUIDTool.getUUID32());
		o.setCreateDate(new Date());

		orderDao.update(o);
		
	}
	
	@Override
	public Order getOrderById(String orderId)
	{
		Order o = new Order();
		o.setOrderId(orderId);;
		return orderDao.find(o);
	}

	@Override
	public List<Order> getOrderList(Order o, PageInfo pi)
	{
		int offset;
		int rows;
		if (null == pi)
		{
			offset = 0;
			rows = orderDao.count();
		}
		else
		{
			offset = pi.getPageNo() * pi.getPageSize();
			rows = pi.getPageSize();
		}
		return orderDao.list(o, offset, rows);
	}

	@Override
	public int countOrder()
	{
		return orderDao.count();
	}
	
	@Override
	public void updateOrderStatus(String orderId, String status)
	{
		Order o = new Order();
		o.setOrderId(orderId);
		// 先根据订单Id查询用订单象
		o = orderDao.find(o);
		if (o != null)
		{
			o.setStatus(status);
			o.setUpdateDate(new Date());
			// 修改订单
			orderDao.update(o);
		}
	}

	@Override
	public int deleteOrder(String orderId)
	{
		return orderDao.delete(orderId);
	}

	public OrderDao getOrderDao()
	{
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao)
	{
		this.orderDao = orderDao;
	}

}
