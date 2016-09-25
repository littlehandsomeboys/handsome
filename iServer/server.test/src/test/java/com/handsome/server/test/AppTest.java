package com.handsome.server.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.handsome.product.api.bean.Product;
import com.handsome.product.api.service.ProductService;
import com.handsome.siteuser.api.bean.SiteUser;
import com.handsome.siteuser.api.service.SiteUserService;

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
		SiteUserService siteUserService = (SiteUserService)ac.getBean("siteUserService");
		SiteUser siteUser = new SiteUser();
		//新增
		siteUserService.creatSiteUser("test", "123", "大蓝鲸");
		//修改
		siteUserService.updateStieUserPwd("test", "321");
		
		//查询
		siteUser = siteUserService.getUserByUserName("test");
		System.out.println(siteUser.toString());
		
		//删除
		siteUserService.deleteUser(siteUser.getSiteUserId());
	}

	@Test
	public void testProduct()
	{
		ProductService productService = (ProductService) ac
				.getBean("productService");
		System.out.println(productService.toString());
		productService.addProduct(new Product());

	}
}
