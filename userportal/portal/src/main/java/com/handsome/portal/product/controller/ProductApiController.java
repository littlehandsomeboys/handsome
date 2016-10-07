/*
 * 
 */
package com.handsome.portal.product.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.handsome.portal.common.bean.ResponseObject;
import com.handsome.product.api.bean.Product;
import com.handsome.product.api.service.ProductService;

/**
 * 
 * @author dell
 *
 */
@Api("产品接口")
@RestController
@RequestMapping("/product/api")
public class ProductApiController
{

	@Autowired
	@Qualifier(value = "productService")
	private ProductService productService;

	public ProductApiController()
	{
		// TODO Auto-generated constructor stub
	}

	@ApiOperation("产品列表查询接口")
	@RequestMapping(value = "/productlist.do", method = RequestMethod.POST)
	public @ResponseBody String productlist(@RequestBody String procuctInfo)
	{
		System.out.println(procuctInfo);
		ResponseObject res = new ResponseObject();
		// 此处测试
		productService.createProduct(new Product());

		res.setData("{procuct:'产品1'}");
		return JSON.toJSONString(res);
	}

}
