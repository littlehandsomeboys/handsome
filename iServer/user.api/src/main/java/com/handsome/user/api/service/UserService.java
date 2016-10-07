package com.handsome.user.api.service;

import java.util.List;

import com.handsome.common.bean.PageInfo;
import com.handsome.user.api.bean.User;

/**
 * 
 * @author dell
 *
 */
public interface UserService
{

	/**
	 * 添加用户
	 * @param u
	 */
	void createUser(User u);
	
	/**
	 * 修改用户基础信息
	 * @param u
	 */
	void updateUser(User u);

	/**
	 * 根据用户Id查询用户
	 * 
	 * @param userId
	 * @return
	 */
	User getUserById(String userId);

	/**
	 * 根据用户名查询用户
	 * 
	 * @param userName
	 * @return
	 */
	User getUserByUserName(String userName);

	/**
	 * 查询用户列表  支持分页 PageInfo为空时查询所有
	 * @param su
	 * @param pi
	 * @return
	 */
	List<User> getUserList(User su, PageInfo pi);
	
	/**
	 * 用户总数
	 * @return
	 */
	int countUser();
	
	/**
	 * 修改用户密码
	 * @param loginName
	 * @param loginPwd
	 */
	void updateUserPwd(String loginName, String loginPwd);

	/**
	 * 启用
	 * @param loginName
	 */
	void updateUserEnabled(String loginName);
	
	/**
	 * 禁用
	 * @param loginName
	 */
	void updateUserUnabled(String loginName);
	
	/**
	 * 根据用户Id删除用户
	 * 
	 * @param userId
	 * @return
	 */
	int deleteUser(String userId);
	
}
