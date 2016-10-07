package com.handsome.order.api.constent;

public interface OrderConstent
{

	/**
	 * 订单状态，0：待卖家确认，1：待买家收货，2：已确认收货，3：撤销
	 */
	static final String STATUS_WAITSURE="0";
	
	/**
	 * 订单状态，0：待卖家确认，1：待买家收货，2：已确认收货，3：撤销
	 */
	static final String STATUS_RECEIVING="1";
	
	/**
	 * 订单状态，0：待卖家确认，1：待买家收货，2：已确认收货，3：撤销
	 */
	static final String STATUS_RECEIVDED="2";
	
	/**
	 * 订单状态，0：待卖家确认，1：待买家收货，2：已确认收货，3：撤销
	 */
	static final String STATUS_CANCEL="3";
	
	/**
	 * 支付方式，0：线下支付
	 */
	static final String PAYTYPE_OFFLINE="0";
	
	/**
	 * 送货方式，0：指定地点自取
	 */
	static final String SENDTYPE_DESTINATION="0";
	
	/**
	 * 送货方式，1：送货上门
	 */
	static final String SENDTYPE_DELIVERY="1";
}
