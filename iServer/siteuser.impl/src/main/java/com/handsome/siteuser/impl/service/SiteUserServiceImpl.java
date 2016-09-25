package com.handsome.siteuser.impl.service;

import java.util.Date;

import com.handsome.common.util.UUIDTool;
import com.handsome.siteuser.api.bean.SiteUser;
import com.handsome.siteuser.api.constent.SiteUserConstent;
import com.handsome.siteuser.api.dao.SiteUserDao;
import com.handsome.siteuser.api.service.SiteUserService;

//@Service(value = "siteUserServiceImpl")
public class SiteUserServiceImpl implements SiteUserService
{

	// @Autowired
	// @Qualifier(value = "siteUserDaoImpl")
	private SiteUserDao siteUserDao;

	@Override
	public void creatSiteUser(String account, String password, String ecName)
	{
		SiteUser su = new SiteUser();
		su.setAccount(account);
		su.setPassword(password);
		su.setEcName(ecName);
		su.setAuthorities(SiteUserConstent.AUTHORITIES_EC);
		su.setEnabled(SiteUserConstent.ENABLED_ON);
		su.setSiteUserId(UUIDTool.getUUID32());
		su.setCreateDate(new Date());

		siteUserDao.add(su);
	}

	@Override
	public SiteUser getUserById(String userId)
	{
		SiteUser su = new SiteUser();
		su.setSiteUserId(userId);
		return siteUserDao.find(su);
	}

	@Override
	public void updateStieUserPwd(String loginName, String loginPwd)
	{
		SiteUser su = new SiteUser();
		su.setAccount(loginName);
		// 先根据用户Id查询用户对象
		SiteUser siteUser = siteUserDao.find(su);
		if (siteUser != null)
		{
			siteUser.setPassword(loginPwd);
			siteUser.setUpdateDate(new Date());
			// 修改用户
			siteUserDao.update(siteUser);
		}
	}

	@Override
	public void updateStieUserEnabled(String loginName)
	{
		SiteUser su = new SiteUser();
		su.setAccount(loginName);
		// 先根据用户Id查询用户对象
		SiteUser siteUser = siteUserDao.find(su);
		if (siteUser != null)
		{
			siteUser.setEnabled(SiteUserConstent.ENABLED_ON);
			;
			siteUser.setUpdateDate(new Date());
			// 修改用户
			siteUserDao.update(siteUser);
		}
	}

	@Override
	public void updateStieUserUnabled(String loginName)
	{
		SiteUser su = new SiteUser();
		su.setAccount(loginName);
		// 先根据用户Id查询用户对象
		SiteUser siteUser = siteUserDao.find(su);
		if (siteUser != null)
		{
			siteUser.setEnabled(SiteUserConstent.ENABLED_OFF);
			siteUser.setUpdateDate(new Date());
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
		if (SiteUserConstent.AUTHORITIES_SUPER.equals(authorities))
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
		SiteUser su = new SiteUser();
		su.setAccount(userName);
		// TODO Auto-generated method stub
		return siteUserDao.find(su);
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
