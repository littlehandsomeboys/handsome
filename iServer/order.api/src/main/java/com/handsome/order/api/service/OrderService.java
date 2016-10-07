package com.handsome.order.api.service;

import java.util.List;

import com.handsome.common.bean.PageInfo;
import com.handsome.order.api.bean.Order;

/**
 * 产品
 *
 */
public interface OrderService
{
	/**
	 * 添加订单
	 * @param o
	 */
	void createProduct(Order o);
	
	/**
	 * 修改订单基础信息
	 * @param p
	 */
	void updateOrder(Order o);

	/**
	 * 根据Id查询订单
	 * 
	 * @param orderId
	 * @return
	 */
	Order getOrderById(String oderId);

	/**
	 * 查询产品列表  支持分页 PageInfo为空时查询所有
	 * @param o
	 * @param pi
	 * @return
	 */
	List<Order> getOrderList(Order p, PageInfo pi);
	
	/**
	 * 用户总数
	 * @return
	 */
	int countOrder();
	
	/**
	 * 修改订单状态
	 * @param orderId
	 * @param status
	 */
	void updateOrderStatus(String orderId, String status);
	
	/**
	 * 根据用户Id删除用户
	 * 
	 * @param orderId
	 * @return
	 */
	int deleteOrder(String orderId);
}
