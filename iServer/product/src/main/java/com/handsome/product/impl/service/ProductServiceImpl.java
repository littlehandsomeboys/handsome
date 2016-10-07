package com.handsome.product.impl.service;

import java.util.Date;
import java.util.List;

import com.handsome.common.bean.PageInfo;
import com.handsome.common.util.UUIDTool;
import com.handsome.product.api.bean.Product;
import com.handsome.product.api.constent.ProductConstent;
import com.handsome.product.api.dao.ProductDao;
import com.handsome.product.api.service.ProductService;

/**
 * Hello world!
 *
 */
public class ProductServiceImpl implements ProductService
{
	private ProductDao productDao;

	@Override
	public void createProduct(Product p)
	{
		p.setProductId(UUIDTool.getUUID32());
		p.setCreateDate(new Date());

		productDao.add(p);
	}

	@Override
	public void updateProduct(Product p)
	{
		p.setProductId(UUIDTool.getUUID32());
		p.setCreateDate(new Date());

		productDao.update(p);
		
	}
	
	@Override
	public Product getProductById(String productId)
	{
		Product p = new Product();
		p.setProductId(productId);;
		return productDao.find(p);
	}

	@Override
	public Product getProductByProductName(String productName)
	{
		Product p = new Product();
		p.setProductName(productName);
		// TODO Auto-generated method stub
		return productDao.find(p);
	}

	@Override
	public List<Product> getProductList(Product p, PageInfo pi)
	{
		int offset;
		int rows;
		if (null == pi)
		{
			offset = 0;
			rows = productDao.count();
		}
		else
		{
			offset = pi.getPageNo() * pi.getPageSize();
			rows = pi.getPageSize();
		}
		return productDao.list(p, offset, rows);
	}

	@Override
	public int countProduct()
	{
		return productDao.count();
	}
	
	@Override
	public void updateProductOnline(String productName)
	{
		Product p = new Product();
		p.setProductName(productName);
		// 先根据用户Id查询用户对象
		p = productDao.find(p);
		if (p != null)
		{
			p.setStatus(ProductConstent.STATUS_ON);
			p.setUpdateDate(new Date());
			// 修改用户
			productDao.update(p);
		}
	}

	@Override
	public void updateProductOffline(String productName)
	{
		Product p = new Product();
		p.setProductName(productName);
		// 先根据用户Id查询用户对象
		p = productDao.find(p);
		if (p != null)
		{
			p.setStatus(ProductConstent.STATUS_OFF);
			p.setUpdateDate(new Date());
			// 修改用户
			productDao.update(p);
		}
	}

	@Override
	public int deleteProduct(String productId)
	{
		return productDao.delete(productId);
	}

	public ProductDao getProductDao()
	{
		return productDao;
	}

	public void setProductDao(ProductDao productDao)
	{
		this.productDao = productDao;
	}

}
