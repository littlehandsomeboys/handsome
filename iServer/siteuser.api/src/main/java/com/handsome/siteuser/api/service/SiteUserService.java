package com.handsome.siteuser.api.service;

import java.util.List;

import com.handsome.common.bean.PageInfo;
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
	void createSiteUser(String account, String password,
			String ecName);

	/**
	 * 根据用户Id查询用户
	 * 
	 * @param userId
	 * @return
	 */
	SiteUser getSiteUserById(String userId);

	/**
	 * 根据用户名查询用户
	 * 
	 * @param userName
	 * @return
	 */
	SiteUser getSiteUserByUserName(String userName);

	/**
	 * 查询管理员列表  支持分页 PageInfo为空时查询所有
	 * @param su
	 * @param pi
	 * @return
	 */
	List<SiteUser> getSiteUserList(SiteUser su, PageInfo pi);
	
	/**
	 * 管理员总数
	 * @return
	 */
	int countSiteUser();
	
	/**
	 * 修改用户密码
	 * @param loginName
	 * @param loginPwd
	 */
	void updateSiteUserPwd(String loginName, String loginPwd);

	/**
	 * 启用
	 * @param loginName
	 */
	void updateSiteUserEnabled(String loginName);
	
	/**
	 * 禁用
	 * @param loginName
	 */
	void updateSiteUserUnabled(String loginName);
	
	/**
	 * 根据用户Id删除用户
	 * 
	 * @param userId
	 * @return
	 */
	int deleteUser(String userId);
	
}
