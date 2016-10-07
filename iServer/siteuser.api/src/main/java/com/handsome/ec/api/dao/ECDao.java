package com.handsome.ec.api.dao;

import java.util.List;

import com.handsome.ec.api.bean.EC;

/**
 * 企业据接口
 * 
 * @author dell
 */
public interface ECDao
{
	/**
	 * 新增
	 * 
	 * @param ec
	 */
	void add(EC ec);

	/**
	 * 获取对象
	 * 
	 * @param ec
	 * @return
	 */
	EC find(EC ec);

	/**
	 * 分页查询列表 
	 * 
	 * @param ec
	 * @param offset
	 * @param rows
	 * @return
	 */
	List<EC> list(EC ec, Integer offset, Integer rows);

	/**
	 * 查询总数
	 * @return
	 */
	int count();
	
	/**
	 * 修改
	 * 
	 * @param ec
	 */
	void update(EC ec);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	int delete(String id);

}
