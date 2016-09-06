/**
 * 
 */
package com.handsome.gateway.facet;

import com.handsome.imp.base.agent.InterfaceManager;
import com.handsome.imp.base.bean.Message;
import com.handsome.imp.base.facet.Demo;

/**
 * @author dell
 *
 */
public class CommonFacet extends InterfaceManager
{

	private Demo demo;
	
	/**
	 * 
	 */
	public CommonFacet()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void selfValid(Message msg)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doBusiness(Message msg)
	{
		// TODO Auto-generated method stub
		demo.hello();
	}

	public Demo getDemo()
	{
		return demo;
	}

	public void setDemo(Demo demo)
	{
		this.demo = demo;
	}

		

}
