package com.handsome.siteuser.impl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.handsome.siteuser.api.bean.SiteUser;
import com.handsome.siteuser.api.dao.SiteUserDao;

/**
 * 
 * @author dell
 *
 */
// @Repository(value = "siteUserDaoImpl")
public class SiteUserDaoImpl extends SqlSessionDaoSupport implements
		SiteUserDao
{
	private static Logger log = Logger.getLogger(SiteUserDaoImpl.class);

	public SiteUserDaoImpl()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public int delete(String id)
	{
		return this.getSqlSession().delete("siteuser.api.SiteUser.delete", id);
	}

	@Override
	public void add(SiteUser u)
	{
		this.getSqlSession().insert("siteuser.api.SiteUser.create", u);
	}

	@Override
	public List<SiteUser> list(SiteUser su, String runTimeAuthorities, Integer offset, Integer rows)
	{
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("ecName", su.getEcName());
		parameterMap.put("account", su.getAccount());
		parameterMap.put("offset", su.getEcName());
		parameterMap.put("reserve5", su.getReserve5());
		parameterMap.put("rows", su.getEcName());
		parameterMap.put("offset", offset);
		parameterMap.put("rows", rows);
		parameterMap.put("runTimeAuthorities", runTimeAuthorities);
		List<SiteUser> siteUserList = this.getSqlSession().selectList(
				"siteuser.api.SiteUser.list", parameterMap);
		return siteUserList;
	}

	@Override
	public int count()
	{
		Integer count = this.getSqlSession().selectOne(
				"siteuser.api.SiteUser.count");
		return count;

	}

	@Override
	public void update(SiteUser u)
	{
		this.getSqlSession().update("siteuser.api.SiteUser.update", u);
	}

	@Override
	public SiteUser find(SiteUser su)
	{
		if (StringUtils.isEmpty(su.getAccount())
				&& StringUtils.isEmpty(su.getSiteUserId()))
			return new SiteUser();

		return this.getSqlSession().selectOne("siteuser.api.SiteUser.find", su);
	}

	// @Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
	{
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
