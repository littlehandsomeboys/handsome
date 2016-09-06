package com.handsome.imp.base.agent;

import com.handsome.imp.base.bean.Message;


public abstract class InterfaceManager
{

	public InterfaceManager()
	{
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 业务校验
	 */
	public abstract void selfValid(Message msg);
	
	/**
	 * 处理业务
	 */
	public abstract void doBusiness(Message msg);
	
	/**
	 * 方法执行入口
	 */
	public void execute(Message msg)
	{
		commonValid(msg);
		
		selfValid(msg);
		
		doBusiness(msg);
	}
	
	/**
	 * 公共校验
	 */
	public void commonValid(Message msg)
	{
		
	}

}
