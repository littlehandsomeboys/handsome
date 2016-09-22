package com.handsome.siteuser.api.dao;

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
	 */
	void add(SiteUser siteUser);

	/**
	 * 获取对象
	 */
	SiteUser find(SiteUser su);
	
	/**
	 * 修改
	 */
	void update(SiteUser siteUser);

	/**
	 * 删除
	 */
	int delete(String id);

}
