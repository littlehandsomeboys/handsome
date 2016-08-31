package com.handsome.admin.auth.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.handsome.admin.auth.bean.SiteUser;
import com.handsome.admin.auth.dao.SiteUserDao;

/**
 * 
 * @author dell
 *
 */
@Repository(value = "siteUserDaoImpl")
public class SiteUserDaoImpl extends SqlSessionDaoSupport implements
		SiteUserDao
{

	public SiteUserDaoImpl()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public int delete(String id)
	{
		return this.getSqlSession().delete(
				"admin.auth.SiteUser.deleteSiteUser", id);
	}

	@Override
	public void add(SiteUser u)
	{
		this.getSqlSession().insert("admin.auth.SiteUser.createSiteUser", u);
	}

	// // 列表
	// public List<SiteUser> list()
	// {
	// return this.getSqlSession().selectList(
	// "cn.itcast.mybatis.domain.User.listAll");
	// }

	@Override
	public void update(SiteUser u)
	{
		this.getSqlSession().update("admin.auth.SiteUser.updateSiteUser", u);
	}

	@Override
	public SiteUser get(String id)
	{
		SiteUser su = new SiteUser();
		su.setId(id);
		return this.getSqlSession().selectOne(
				"admin.auth.SiteUser.getSiteUser", su);
	}

	@Override
	public SiteUser getByUserName(String userName)
	{
		SiteUser su = new SiteUser();
		su.setUserName(userName);
		return this.getSqlSession().selectOne(
				"admin.auth.SiteUser.getSiteUser", su);
	}

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
	{
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
