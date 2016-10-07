package com.handsome.order.api.dao;

import java.util.List;

import com.handsome.order.api.bean.Order;


public interface OrderDao
{
	/**
	 * 新增
	 * @param o
	 */
	void add(Order o);
	
	/**
	 * 获取对象
	 * 
	 * @param o
	 * @return
	 */
	Order find(Order o);

	/**
	 * 分页查询列表 
	 * 
	 * @param p
	 * @param offset
	 * @param rows
	 * @return
	 */
	List<Order> list(Order o, Integer offset, Integer rows);

	/**
	 * 查询总数
	 * @return
	 */
	int count();
	
	/**
	 * 修改
	 * 
	 * @param p
	 */
	void update(Order o);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	int delete(String id);
}
