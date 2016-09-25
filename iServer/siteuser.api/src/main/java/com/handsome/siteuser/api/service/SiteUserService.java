package com.handsome.siteuser.api.service;

import com.handsome.siteuser.api.bean.SiteUser;

/**
 * 
 * @author dell
 *
 */
public interface SiteUserService
{

	/**
	 * 添加系统管理员
	 * @param account
	 * @param password
	 * @param ecName
	 */
	void creatSiteUser(String account, String password,
			String ecName);

	/**
	 * 根据用户Id查询用户
	 * 
	 * @param userId
	 * @return
	 */
	SiteUser getUserById(String userId);

	/**
	 * 根据用户名查询用户
	 * 
	 * @param userName
	 * @return
	 */
	SiteUser getUserByUserName(String userName);

	/**
	 * 修改用户密码
	 * @param loginName
	 * @param loginPwd
	 */
	void updateStieUserPwd(String loginName, String loginPwd);

	/**
	 * 启用
	 * @param loginName
	 */
	void updateStieUserEnabled(String loginName);
	
	/**
	 * 禁用
	 * @param loginName
	 */
	void updateStieUserUnabled(String loginName);
	
	/**
	 * 根据用户Id删除用户
	 * 
	 * @param userId
	 * @return
	 */
	int deleteUser(String userId);

	/**
	 * 查询权限
	 * 
	 * @param aAuthorities
	 * @return
	 */
	public String findAuthorities(String aAuthorities);
}
