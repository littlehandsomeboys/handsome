package com.handsome.siteuser.impl.dao;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.handsome.siteuser.api.bean.SiteUser;
import com.handsome.siteuser.api.dao.SiteUserDao;

/**
 * 
 * @author dell
 *
 */
//@Repository(value = "siteUserDaoImpl")
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
				"siteuser.api.SiteUser.delete", id);
	}

	@Override
	public void add(SiteUser u)
	{
		this.getSqlSession().insert("siteuser.api.SiteUser.create", u);
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
		this.getSqlSession().update("siteuser.api.SiteUser.update", u);
	}

	@Override
	public SiteUser find(SiteUser su)
	{
		if (StringUtils.isEmpty(su.getAccount()) && StringUtils.isEmpty(su.getSiteUserId()))
			return new SiteUser();
			
		return this.getSqlSession().selectOne(
				"siteuser.api.SiteUser.find", su);
	}

//	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
	{
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
