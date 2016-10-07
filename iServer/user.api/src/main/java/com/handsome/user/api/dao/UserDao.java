package com.handsome.user.api.dao;

import java.util.List;

import com.handsome.user.api.bean.User;

/**
 * 用户数据接口
 * 
 * @author dell
 */
public interface UserDao
{
	/**
	 * 新增
	 * 
	 * @param user
	 */
	void add(User user);

	/**
	 * 获取对象
	 * 
	 * @param u
	 * @return
	 */
	User find(User u);

	/**
	 * 分页查询列表 
	 * 
	 * @param u
	 * @param offset
	 * @param rows
	 * @return
	 */
	List<User> list(User u, Integer offset, Integer rows);

	/**
	 * 查询总数
	 * @return
	 */
	int count();
	
	/**
	 * 修改
	 * 
	 * @param user
	 */
	void update(User user);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	int delete(String id);

}
