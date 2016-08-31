package com.handsome.admin.auth.dao;

import com.handsome.admin.auth.bean.SiteUser;

/**
 * 用户数据接口
 * 
 * @author dell
 */
public interface SiteUserDao
{
	/**
	 * 新增
	 */
	void add(SiteUser siteUser);

	/**
	 * 根据id获取对象
	 */
	SiteUser get(String id);

	/**
	 * 根据账号获取对象
	 */
	SiteUser getByUserName(String userName);
	
	/**
	 * 修改
	 */
	void update(SiteUser siteUser);

	/**
	 * 删除
	 */
	int delete(String id);

}
