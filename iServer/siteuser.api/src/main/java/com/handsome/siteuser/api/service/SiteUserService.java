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
	 * @param su
	 */
	void createSiteUser(SiteUser su);

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
	 * @param runTimeAuthorities
	 * @return
	 */
	List<SiteUser> getSiteUserList(SiteUser su, PageInfo pi, String runTimeAuthorities);
	
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
	 * 修改用户基础信息
	 * @param loginName
	 */
	void updateSiteUserInfo(SiteUser su);
	
	/**
	 * 根据用户Id删除用户
	 * 
	 * @param userId
	 * @return
	 */
	int deleteUser(String userId);
	
}
