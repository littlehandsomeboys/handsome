package com.handsome.server.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.handsome.common.bean.PageInfo;
import com.handsome.ec.api.service.ECService;
import com.handsome.order.api.service.OrderService;
import com.handsome.pic.api.bean.Pic;
import com.handsome.pic.api.service.PicService;
import com.handsome.product.api.bean.Product;
import com.handsome.product.api.service.ProductService;
import com.handsome.producttype.api.service.ProductTypeService;
import com.handsome.siteuser.api.bean.SiteUser;
import com.handsome.siteuser.api.service.SiteUserService;
import com.handsome.user.api.service.UserService;

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
		siteUser.setAccount("test");
		siteUser.setPassword("123");
		siteUser.setEcName("大蓝鲸");
		siteUser.setReserve0("介绍");
		siteUser.setReserve1("头像");
		siteUser.setReserve2("生活照");
		siteUser.setReserve3("相关证书");
		siteUser.setReserve4("执教经历");
		siteUser.setReserve5("教师名字");
		siteUser.setReserve6("普通");
		siteUser.setReserve7("学历");
		siteUser.setReserve8("");
		siteUser.setReserve9("");
		siteUserService.createSiteUser(siteUser);
		
		//查询
		siteUser = siteUserService.getSiteUserByUserName("test");
		System.out.println(siteUser.toString());
		
		//修改
		siteUser.setReserve0("");
		siteUser.setReserve1("");
		siteUser.setReserve2("");
		siteUser.setReserve3("");
		siteUser.setReserve4("");
		siteUser.setReserve5("");
		siteUser.setReserve6("");
		siteUser.setReserve7("");
		siteUser.setReserve8("");
		siteUser.setReserve9("");
		siteUserService.updateSiteUserInfo(siteUser);
		siteUserService.updateSiteUserPwd("test", "321");
		
		//查询
		siteUser = siteUserService.getSiteUserByUserName("test");
		System.out.println(siteUser.toString());
		
		//查询列表
		PageInfo pi = new PageInfo();
		List<SiteUser> siteUserList = siteUserService.getSiteUserList(siteUser, pi, "1");
		System.out.println("条件查询:"+siteUserList.size());
		siteUserList = siteUserService.getSiteUserList(new SiteUser(), pi, "1");
		System.out.println("空条件查询:"+siteUserList.size());
		pi.setPageNo(1);
		pi.setPageSize(1);
		siteUserList = siteUserService.getSiteUserList(new SiteUser(), pi, "1");
		System.out.println("第二页查询:"+siteUserList.size());
		siteUserList = siteUserService.getSiteUserList(new SiteUser(), null, "1");
		System.out.println("全查询:"+siteUserList.size());
		
		//查询总数
		System.out.println(siteUserService.countSiteUser());
		
		//删除
		siteUserService.deleteUser(siteUser.getSiteUserId());
	}
	
	@Test
	public void testPic()
	{
		PicService picService = (PicService)ac.getBean("picService");
		Pic pic = new Pic();
		//新增
//		pic.setDir("/share/pic");
//		pic.setUrl("https://www.baidu.com/img/baidu_jgylogo3.gif");
//		picService.createPic(pic);
		
		//查询
		pic.setPicId("8a8019d8494a47d3a662738cb13129f8");
		pic = picService.getPic(pic);
		System.out.println(pic.toString());
		
		//修改
		
		pic.setDir("/share/head");
		pic.setUrl("http://avatar.csdn.net/8/6/9/1_u014639561.jpg");;
		picService.updatePic(pic);
		
		//查询
		pic = picService.getPic(pic);
		System.out.println(pic.toString());
		
		//删除
//		pic.setPicId("498185bbbba54fce98c63d45a2f35b9c");
//		picService.deletePic(pic.getPicId());
	}

	@Test
	public void testEC()
	{
		ECService ecService = (ECService) ac
				.getBean("ecService");
		System.out.println(ecService.getECById("ec001").toString());

	}
	
	@Test
	public void testUser()
	{
		UserService userService = (UserService) ac
				.getBean("userService");
		System.out.println(userService.getUserByUserName("chencheng").toString());

	}
	
	@Test
	public void testProduct()
	{
		ProductService productService = (ProductService) ac
				.getBean("productService");
		System.out.println(productService.getProductByProductName("产品a"));

	}
	
	@Test
	public void testProductType()
	{
		ProductTypeService productTypeService = (ProductTypeService) ac
				.getBean("productTypeService");
		System.out.println(productTypeService.getProductTypeByProductTypeName("产品类型A"));

	}
	
	@Test
	public void testOrder()
	{
		OrderService orderService = (OrderService) ac
				.getBean("orderService");
		System.out.println(orderService.getOrderById("order001"));

	}
}
