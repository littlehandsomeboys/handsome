package com.handsome.user.impl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.handsome.user.api.bean.User;
import com.handsome.user.api.dao.UserDao;

/**
 * 
 * @author dell
 *
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements
		UserDao
{
	private static Logger log = Logger.getLogger(UserDaoImpl.class);

	public UserDaoImpl()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public int delete(String id)
	{
		return this.getSqlSession().delete("user.api.User.delete", id);
	}

	@Override
	public void add(User u)
	{
		try
		{
			log.debug("begin" + u.toString());
			this.getSqlSession().insert("user.api.User.create", u);
			log.debug("end");
		}
		catch (Exception e)
		{
			log.error(e.toString(), e);
			System.out.println(e);
		}
	}

	@Override
	public List<User> list(User u, Integer offset, Integer rows)
	{
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("account", u.getAccount());
		parameterMap.put("offset", offset);
		parameterMap.put("rows", rows);
		List<User> userList = this.getSqlSession().selectList(
				"user.api.User.list", parameterMap);
		return userList;
	}

	@Override
	public int count()
	{
		Integer count = this.getSqlSession().selectOne(
				"user.api.User.count");
		return count;

	}

	@Override
	public void update(User u)
	{
		this.getSqlSession().update("user.api.User.update", u);
	}

	@Override
	public User find(User u)
	{
		if (StringUtils.isEmpty(u.getAccount())
				&& StringUtils.isEmpty(u.getUserId()))
			return new User();

		return this.getSqlSession().selectOne("user.api.User.find", u);
	}

	// @Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
	{
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
