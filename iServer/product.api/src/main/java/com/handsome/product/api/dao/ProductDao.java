package com.handsome.product.api.dao;

import java.util.List;

import com.handsome.product.api.bean.Product;

public interface ProductDao
{
	/**
	 * 新增
	 * @param product
	 */
	void add(Product product);
	
	/**
	 * 获取对象
	 * 
	 * @param p
	 * @return
	 */
	Product find(Product p);

	/**
	 * 分页查询列表 
	 * 
	 * @param p
	 * @param offset
	 * @param rows
	 * @return
	 */
	List<Product> list(Product p, Integer offset, Integer rows);

	/**
	 * 查询总数
	 * @return
	 */
	int count();
	
	/**
	 * 修改
	 * 
	 * @param p
	 */
	void update(Product p);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	int delete(String id);
}
