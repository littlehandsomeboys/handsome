package com.handsome.user.impl.service;

import java.util.Date;
import java.util.List;

import com.handsome.common.bean.PageInfo;
import com.handsome.common.util.UUIDTool;
import com.handsome.user.api.bean.User;
import com.handsome.user.api.constent.UserConstent;
import com.handsome.user.api.dao.UserDao;
import com.handsome.user.api.service.UserService;

//@Service(value = "siteUserServiceImpl")
public class UserServiceImpl implements UserService
{

	// @Autowired
	// @Qualifier(value = "siteUserDaoImpl")
	private UserDao userDao;

	@Override
	public void createUser(User u)
	{
		u.setUserId(UUIDTool.getUUID32());
		u.setCreateDate(new Date());

		userDao.add(u);
	}

	@Override
	public void updateUser(User u)
	{
		u.setUserId(UUIDTool.getUUID32());
		u.setCreateDate(new Date());

		userDao.update(u);
		
	}
	
	@Override
	public User getUserById(String userId)
	{
		User u = new User();
		u.setUserId(userId);
		return userDao.find(u);
	}

	@Override
	public User getUserByUserName(String userName)
	{
		User u = new User();
		u.setAccount(userName);
		// TODO Auto-generated method stub
		return userDao.find(u);
	}

	@Override
	public List<User> getUserList(User su, PageInfo pi)
	{
		int offset;
		int rows;
		if (null == pi)
		{
			offset = 0;
			rows = userDao.count();
		}
		else
		{
			offset = pi.getPageNo() * pi.getPageSize();
			rows = pi.getPageSize();
		}
		return userDao.list(su, offset, rows);
	}

	@Override
	public int countUser()
	{
		return userDao.count();
	}
	
	@Override
	public void updateUserPwd(String loginName, String loginPwd)
	{
		User u = new User();
		u.setAccount(loginName);
		// 先根据用户Id查询用户对象
		u = userDao.find(u);
		if (u != null)
		{
			u.setPassword(loginPwd);
			u.setUpdateDate(new Date());
			// 修改用户
			userDao.update(u);
		}
	}

	@Override
	public void updateUserEnabled(String loginName)
	{
		User u = new User();
		u.setAccount(loginName);
		// 先根据用户Id查询用户对象
		u = userDao.find(u);
		if (u != null)
		{
			u.setEnabled(UserConstent.ENABLED_ON);
			u.setUpdateDate(new Date());
			// 修改用户
			userDao.update(u);
		}
	}

	@Override
	public void updateUserUnabled(String loginName)
	{
		User u = new User();
		u.setAccount(loginName);
		// 先根据用户Id查询用户对象
		u = userDao.find(u);
		if (u != null)
		{
			u.setEnabled(UserConstent.ENABLED_OFF);
			u.setUpdateDate(new Date());
			// 修改用户
			userDao.update(u);
		}
	}

	@Override
	public int deleteUser(String userId)
	{
		return userDao.delete(userId);
	}

	public UserDao getSiteUserDao()
	{
		return userDao;
	}

	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}


}
