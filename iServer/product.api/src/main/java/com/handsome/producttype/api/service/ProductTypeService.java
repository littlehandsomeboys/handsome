package com.handsome.producttype.api.service;

import java.util.List;

import com.handsome.common.bean.PageInfo;
import com.handsome.producttype.api.bean.ProductType;

/**
 * 产品
 *
 */
public interface ProductTypeService
{
	/**
	 * 添加产品类型
	 * @param p
	 */
	void createProductType(ProductType pt);
	
	/**
	 * 修改产品类型基础信息
	 * @param p
	 */
	void updateProductType(ProductType pt);

	/**
	 * 根据Id查询产品类型
	 * 
	 * @param productTypeId
	 * @return
	 */
	ProductType getProductTypeById(String productTypeId);

	/**
	 * 根据名称查询产品类型
	 * 
	 * @param productTypeName
	 * @return
	 */
	ProductType getProductTypeByProductTypeName(String productTypeName);

	/**
	 * 查询产品列表  支持分页 PageInfo为空时查询所有
	 * @param pt
	 * @param pi
	 * @return
	 */
	List<ProductType> getProductTypeList(ProductType p, PageInfo pi);
	
	/**
	 * 产品类型总数
	 * @return
	 */
	int countProductType();
	
	/**
	 * 根据用户Id删除用户
	 * 
	 * @param productTypeId
	 * @return
	 */
	int deleteProductType(String productTypeId);
}
