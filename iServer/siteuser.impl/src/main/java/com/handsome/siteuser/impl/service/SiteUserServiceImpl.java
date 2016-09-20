package com.handsome.siteuser.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.handsome.siteuser.api.bean.SiteUser;
import com.handsome.siteuser.api.dao.SiteUserDao;
import com.handsome.siteuser.api.service.SiteUserService;

//@Service(value = "siteUserServiceImpl")
public class SiteUserServiceImpl implements SiteUserService
{

//	@Autowired
//	@Qualifier(value = "siteUserDaoImpl")
	private SiteUserDao siteUserDao;

	@Override
	public void addSystemUser(String loginName, String loginPwd)
	{
		SiteUser user = new SiteUser();
		user.setUserName(loginName);
		user.setPassword(loginPwd);
		// 用户类型 1 管理员 2 普通用户
		user.setAuthorities("1");
		siteUserDao.add(null);
	}

	@Override
	public void addNormalUser(String loginName, String loginPwd)
	{
		SiteUser user = new SiteUser();
		user.setUserName(loginName);
		user.setPassword(loginPwd);
		// 用户类型 1 管理员 2 普通用户
		user.setAuthorities("2");
		siteUserDao.add(null);
	}

	@Override
	public SiteUser getUserById(String userId)
	{
		return siteUserDao.get(userId);
	}

	@Override
	public void updateUser(String userId, String loginName, String loginPwd)
	{
		// 先根据用户Id查询用户对象
		SiteUser siteUser = siteUserDao.get(userId);
		if (siteUser != null)
		{
			siteUser.setUserName(loginName);
			siteUser.setPassword(loginPwd);
			// 修改用户
			siteUserDao.update(siteUser);
		}
	}

	@Override
	public int deleteUser(String userId)
	{
		return siteUserDao.delete(userId);
	}

	@Override
	public String findAuthorities(String authorities)
	{
		if ("1".equals(authorities))
		{
			return "系统管理员";
		}
		else
		{
			return "普通用户";
		}
	}

	@Override
	public SiteUser getUserByUserName(String userName)
	{
		// TODO Auto-generated method stub
		return siteUserDao.getByUserName(userName);
	}

	public SiteUserDao getSiteUserDao()
	{
		return siteUserDao;
	}

	public void setSiteUserDao(SiteUserDao siteUserDao)
	{
		this.siteUserDao = siteUserDao;
	}

}
