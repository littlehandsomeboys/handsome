package com.handsome.server.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.handsome.common.bean.PageInfo;
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
		siteUser = siteUserService.getSiteUserByUserName("test");
		System.out.println(siteUser.toString());
		
		//查询列表
		PageInfo pi = new PageInfo();
		List<SiteUser> siteUserList = siteUserService.getSiteUserList(siteUser, pi);
		System.out.println("条件查询:"+siteUserList.size());
		siteUserList = siteUserService.getSiteUserList(new SiteUser(), pi);
		System.out.println("空条件查询:"+siteUserList.size());
		pi.setPageNo(1);
		pi.setPageSize(1);
		siteUserList = siteUserService.getSiteUserList(new SiteUser(), pi);
		System.out.println("第二页查询:"+siteUserList.size());
		siteUserList = siteUserService.getSiteUserList(new SiteUser(), null);
		System.out.println("全查询:"+siteUserList.size());
		
		//查询总数
		System.out.println(siteUserService.countSiteUser());
		
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
