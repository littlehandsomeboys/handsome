package com.handsome.admin.auth.service;

import com.handsome.admin.auth.bean.SiteUser;

/**
 * 
 * @author dell
 *
 */
public interface SiteUserService
{

	/**
	 * 添加系统管理员
	 * @param loginName
	 * @param loginPwd
	 */
	void addSystemUser(String loginName, String loginPwd);

	/**
	 * 添加普通用户
	 * @param loginName
	 * @param loginPwd
	 */
	void addNormalUser(String loginName, String loginPwd);

	/**
	 * 根据用户Id查询用户
	 * @param userId
	 * @return
	 */
	SiteUser getUserById(String userId);

	/**
	 * 根据用户名查询用户
	 * @param userName
	 * @return
	 */
	SiteUser getUserByUserName(String userName);
	
	/**
	 * 修改用户信息
	 * @param userId
	 * @param loginName
	 * @param loginPwd
	 */
	void updateUser(String userId, String loginName, String loginPwd);

	/**
	 * 根据用户Id删除用户
	 * @param userId
	 * @return
	 */
	int deleteUser(String userId);

	/**
	 * 查询权限
	 * @param aAuthorities
	 * @return
	 */
	public String findAuthorities(String aAuthorities);
}
