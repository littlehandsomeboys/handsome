/**
 * 
 */
package com.handsome.imp.base.facet.impl;

import com.handsome.imp.base.facet.Demo;
import com.handsome.product.api.bean.Product;
import com.handsome.product.api.service.ProductService;

/**
 * @author dell
 *
 */
public class DemoImpl implements Demo
{
	private ProductService productService;

	/**
	 * 
	 */
	public DemoImpl()
	{
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void hello()
	{
		// TODO Auto-generated method stub
		//hessian接口测试
		productService.createProduct(new Product());
	}

	public ProductService getProductService()
	{
		return productService;
	}

	public void setProductService(ProductService productService)
	{
		this.productService = productService;
	}

}
