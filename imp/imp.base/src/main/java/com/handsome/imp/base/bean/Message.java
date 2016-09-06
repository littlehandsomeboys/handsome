/**
 * 
 */
package com.handsome.imp.base.bean;

import java.io.Serializable;

/**
 * @author dell
 *
 */
public class Message implements Serializable
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Message()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * 消息头
	 */
	private Header head;

	/**
	 * 消息体
	 */
	private Body body;

	public Header getHead()
	{
		return head;
	}

	public void setHead(Header head)
	{
		this.head = head;
	}

	public Body getBody()
	{
		return body;
	}

	public void setBody(Body body)
	{
		this.body = body;
	}

}
