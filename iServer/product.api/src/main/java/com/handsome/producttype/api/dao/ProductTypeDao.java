package com.handsome.producttype.api.dao;

import java.util.List;

import com.handsome.producttype.api.bean.ProductType;

public interface ProductTypeDao
{
	/**
	 * 新增
	 * @param pt
	 */
	void add(ProductType pt);
	
	/**
	 * 获取对象
	 * 
	 * @param pt
	 * @return
	 */
	ProductType find(ProductType pt);

	/**
	 * 分页查询列表 
	 * 
	 * @param pt
	 * @param offset
	 * @param rows
	 * @return
	 */
	List<ProductType> list(ProductType pt, Integer offset, Integer rows);

	/**
	 * 查询总数
	 * @return
	 */
	int count();
	
	/**
	 * 修改
	 * 
	 * @param pt
	 */
	void update(ProductType pt);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	int delete(String id);
}
