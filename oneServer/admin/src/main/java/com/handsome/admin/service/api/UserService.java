package com.handsome.admin.service.api;

import java.util.List;

import com.handsome.admin.ao.UserAO;

public interface UserService {

	/**
	 * 根据用户名查询用户
	 * @param account
	 * @return
	 */
	public UserAO findUser(String account);
	
	/**
	 * 查询用户列表
	 * @param userAO
	 * @return
	 */
	public List<UserAO> queryUser(UserAO userAO);
}
