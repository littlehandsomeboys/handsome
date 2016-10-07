package com.handsome.producttype.impl.service;

import java.util.Date;
import java.util.List;

import com.handsome.common.bean.PageInfo;
import com.handsome.common.util.UUIDTool;
import com.handsome.producttype.api.bean.ProductType;
import com.handsome.producttype.api.dao.ProductTypeDao;
import com.handsome.producttype.api.service.ProductTypeService;

/**
 * Hello world!
 *
 */
public class ProductTypeServiceImpl implements ProductTypeService
{
	private ProductTypeDao productTypeDao;

	@Override
	public void createProductType(ProductType pt)
	{
		pt.setProductTypeId(UUIDTool.getUUID32());
		pt.setCreateDate(new Date());

		productTypeDao.add(pt);
	}

	@Override
	public void updateProductType(ProductType pt)
	{
		pt.setProductTypeId(UUIDTool.getUUID32());
		pt.setCreateDate(new Date());

		productTypeDao.update(pt);
		
	}
	
	@Override
	public ProductType getProductTypeById(String productTypeId)
	{
		ProductType pt = new ProductType();
		pt.setProductTypeId(productTypeId);;
		return productTypeDao.find(pt);
	}

	@Override
	public ProductType getProductTypeByProductTypeName(String productTypeName)
	{
		ProductType pt = new ProductType();
		pt.setProductTypeName(productTypeName);
		// TODO Auto-generated method stub
		return productTypeDao.find(pt);
	}

	@Override
	public List<ProductType> getProductTypeList(ProductType pt, PageInfo pi)
	{
		int offset;
		int rows;
		if (null == pi)
		{
			offset = 0;
			rows = productTypeDao.count();
		}
		else
		{
			offset = pi.getPageNo() * pi.getPageSize();
			rows = pi.getPageSize();
		}
		return productTypeDao.list(pt, offset, rows);
	}

	@Override
	public int countProductType()
	{
		return productTypeDao.count();
	}

	@Override
	public int deleteProductType(String productTypeId)
	{
		return productTypeDao.delete(productTypeId);
	}

	public ProductTypeDao getProductTypeDao()
	{
		return productTypeDao;
	}

	public void setProductTypeDao(ProductTypeDao productTypeDao)
	{
		this.productTypeDao = productTypeDao;
	}

}
