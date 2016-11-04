package com.handsome.siteuser.impl.service;

import java.util.Date;
import java.util.List;

import com.handsome.common.bean.PageInfo;
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
	public void createSiteUser(SiteUser su)
	{
		su.setAuthorities(SiteUserConstent.AUTHORITIES_EC);
		su.setEnabled(SiteUserConstent.ENABLED_ON);
		su.setSiteUserId(UUIDTool.getUUID32());
		su.setCreateDate(new Date());

		siteUserDao.add(su);
	}

	@Override
	public SiteUser getSiteUserById(String userId)
	{
		SiteUser su = new SiteUser();
		su.setSiteUserId(userId);
		return siteUserDao.find(su);
	}

	@Override
	public SiteUser getSiteUserByUserName(String userName)
	{
		SiteUser su = new SiteUser();
		su.setAccount(userName);
		// TODO Auto-generated method stub
		return siteUserDao.find(su);
	}

	@Override
	public List<SiteUser> getSiteUserList(SiteUser su, PageInfo pi, String runTimeAuthorities)
	{
		int offset;
		int rows;
		if (null == pi)
		{
			offset = 0;
			rows = siteUserDao.count();
		}
		else
		{
			offset = (pi.getPageNo() - 1) * pi.getPageSize();
			rows = pi.getPageSize();
		}
		return siteUserDao.list(su, runTimeAuthorities, offset, rows);
	}

	@Override
	public int countSiteUser()
	{
		return siteUserDao.count();
	}

	@Override
	public void updateSiteUserPwd(String loginName, String loginPwd)
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
	public void updateSiteUserEnabled(String loginName)
	{
		SiteUser su = new SiteUser();
		su.setAccount(loginName);
		// 先根据用户Id查询用户对象
		SiteUser siteUser = siteUserDao.find(su);
		if (siteUser != null)
		{
			siteUser.setEnabled(SiteUserConstent.ENABLED_ON);
			siteUser.setUpdateDate(new Date());
			// 修改用户
			siteUserDao.update(siteUser);
		}
	}

	@Override
	public void updateSiteUserUnabled(String loginName)
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
	public void updateSiteUserInfo(SiteUser su)
	{
		// 先根据用户名查询用户对象
		SiteUser siteUser = new SiteUser();
		siteUser.setAccount(su.getAccount());
		siteUser = siteUserDao.find(siteUser);
		if (siteUser != null)
		{
			siteUser.setReserve0(su.getReserve0());
			siteUser.setReserve1(su.getReserve1());
			siteUser.setReserve2(su.getReserve2());
			siteUser.setReserve3(su.getReserve3());
			siteUser.setReserve4(su.getReserve4());
			siteUser.setReserve5(su.getReserve5());
			siteUser.setReserve6(su.getReserve6());
			siteUser.setReserve7(su.getReserve7());
			siteUser.setReserve8(su.getReserve8());
			siteUser.setReserve9(su.getReserve9());

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

	public SiteUserDao getSiteUserDao()
	{
		return siteUserDao;
	}

	public void setSiteUserDao(SiteUserDao siteUserDao)
	{
		this.siteUserDao = siteUserDao;
	}

}
