package com.handsome.order.api.bean;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 订单ID
	 */
	private String orderId;
	
	/**
	 * 订单包含产品名
	 */
	private String products;
	
	/**
	 * 下单用户账号
	 */
	private String userAccount;
	
	/**
	 * 送货方式，0：指定地点自取，1：送货上门
	 */
	private String sendType;
	
	/**
	 * 支付方式，0：线下支付
	 */
	private String payType;
	
	/**
	 * 送货地点
	 */
	private String address;
	
	/**
	 * 历史纪录，list中的历史纪录按顺序发生，靠前的是先发生的
	 */
	private String history;
	
	/**
	 * 订单状态，0：待卖家确认，1：待买家收货，2：已确认收货，3：撤销
	 */
	private String status;
	
	/**
	 * 归属企业名称
	 */
	private String ecName;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 更新时间
	 */
	private Date updateDate;

	public String getOrderId()
	{
		return orderId;
	}

	public void setOrderId(String orderId)
	{
		this.orderId = orderId;
	}

	public String getProducts()
	{
		return products;
	}

	public void setProducts(String products)
	{
		this.products = products;
	}

	public String getUserAccount()
	{
		return userAccount;
	}

	public void setUserAccount(String userAccount)
	{
		this.userAccount = userAccount;
	}

	public String getPayType()
	{
		return payType;
	}

	public void setPayType(String payType)
	{
		this.payType = payType;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getHistory()
	{
		return history;
	}

	public void setHistory(String history)
	{
		this.history = history;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getEcName()
	{
		return ecName;
	}

	public void setEcName(String ecName)
	{
		this.ecName = ecName;
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	public Date getUpdateDate()
	{
		return updateDate;
	}

	public void setUpdateDate(Date updateDate)
	{
		this.updateDate = updateDate;
	}

	public String getSendType()
	{
		return sendType;
	}

	public void setSendType(String sendType)
	{
		this.sendType = sendType;
	}

	@Override
	public String toString()
	{
		return "Order [orderId=" + orderId + ", products=" + products
				+ ", userAccount=" + userAccount + ", sendType=" + sendType
				+ ", payType=" + payType + ", address=" + address
				+ ", history=" + history + ", status=" + status + ", ecName="
				+ ecName + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}


}
