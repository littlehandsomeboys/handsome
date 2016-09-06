/**
 * 
 */
package com.handsome.imp.base.bean;

import java.io.Serializable;

/**
 * @author dell
 *
 */
public class Body implements Serializable
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Body()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * 时间戳
	 */
	private String timestemp;
	
	/**
	 * 消息名
	 */
	private String msgName;
	
	/**
	 * 事物id
	 */
	private String transactionID;
	
	/**
	 * 消息内容
	 */
	private Object msgContent;

	public String getTimestemp()
	{
		return timestemp;
	}

	public void setTimestemp(String timestemp)
	{
		this.timestemp = timestemp;
	}

	public String getMsgName()
	{
		return msgName;
	}

	public void setMsgName(String msgName)
	{
		this.msgName = msgName;
	}

	public Object getMsgContent()
	{
		return msgContent;
	}

	public void setMsgContent(Object msgContent)
	{
		this.msgContent = msgContent;
	}

	public String getTransactionID()
	{
		return transactionID;
	}

	public void setTransactionID(String transactionID)
	{
		this.transactionID = transactionID;
	}
	
	
}
