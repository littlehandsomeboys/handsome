package com.handsome.server.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{
		"classpath:spring/applicationContext_bean.xml",
		"classpath:spring/applicationContext_hessian.xml" })
//@WebAppConfiguration
public class AppTest
{
	@Autowired
	private ApplicationContext ac;

	@Test
	public void testSiteUser()
	{
		
	}
	
}
