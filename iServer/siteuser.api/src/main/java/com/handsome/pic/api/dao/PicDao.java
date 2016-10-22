package com.handsome.pic.api.dao;

import java.util.List;

import com.handsome.pic.api.bean.Pic;

/**
 * 图片接口
 * 
 * @author dell
 */
public interface PicDao
{
	/**
	 * 新增
	 * 
	 * @param pic
	 */
	void add(Pic pic);

	/**
	 * 获取对象
	 * 
	 * @param pic
	 * @return
	 */
	Pic find(Pic pic);

	/**
	 * 分页查询列表 
	 * 
	 * @param pic
	 * @param offset
	 * @param rows
	 * @return
	 */
	List<Pic> list(Pic pic, Integer offset, Integer rows);

	/**
	 * 查询总数
	 * @return
	 */
	int count();
	
	/**
	 * 修改
	 * 
	 * @param pic
	 */
	void update(Pic pic);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	int delete(String id);

}
