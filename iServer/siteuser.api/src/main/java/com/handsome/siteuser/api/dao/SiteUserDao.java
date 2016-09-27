package com.handsome.siteuser.api.dao;

import java.util.List;

import com.handsome.siteuser.api.bean.SiteUser;

/**
 * 用户数据接口
 * 
 * @author dell
 */
public interface SiteUserDao
{
	/**
	 * 新增
	 * 
	 * @param siteUser
	 */
	void add(SiteUser siteUser);

	/**
	 * 获取对象
	 * 
	 * @param su
	 * @return
	 */
	SiteUser find(SiteUser su);

	/**
	 * 分页查询列表 
	 * 
	 * @param su
	 * @param offset
	 * @param rows
	 * @return
	 */
	List<SiteUser> list(SiteUser su, Integer offset, Integer rows);

	/**
	 * 查询总数
	 * @return
	 */
	int count();
	
	/**
	 * 修改
	 * 
	 * @param siteUser
	 */
	void update(SiteUser siteUser);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	int delete(String id);

}
