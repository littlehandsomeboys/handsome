package com.handsome.product.api.service;

import java.util.List;

import com.handsome.common.bean.PageInfo;
import com.handsome.product.api.bean.Product;

/**
 * 产品
 *
 */
public interface ProductService
{
	/**
	 * 添加产品
	 * @param p
	 */
	void createProduct(Product p);
	
	/**
	 * 修改产品基础信息
	 * @param p
	 */
	void updateProduct(Product p);

	/**
	 * 根据用户Id查询用户
	 * 
	 * @param productId
	 * @return
	 */
	Product getProductById(String productId);

	/**
	 * 根据名称查询产品
	 * 
	 * @param productName
	 * @return
	 */
	Product getProductByProductName(String productName);

	/**
	 * 查询产品列表  支持分页 PageInfo为空时查询所有
	 * @param p
	 * @param pi
	 * @return
	 */
	List<Product> getProductList(Product p, PageInfo pi);
	
	/**
	 * 产品总数
	 * @return
	 */
	int countProduct();
	
	/**
	 * 上线
	 * @param productName
	 */
	void updateProductOnline(String productName);
	
	/**
	 * 下线
	 * @param productName
	 */
	void updateProductOffline(String productName);
	
	/**
	 * 根据用户Id删除用户
	 * 
	 * @param productId
	 * @return
	 */
	int deleteProduct(String productId);
}
