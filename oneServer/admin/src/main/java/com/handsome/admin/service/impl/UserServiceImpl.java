/**
 * 
 */
package com.handsome.admin.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.handsome.admin.ao.UserAO;
import com.handsome.admin.ao.bean.User;
import com.handsome.admin.ao.bean.UserExample;
import com.handsome.admin.dao.api.generator.UserMapper;
import com.handsome.admin.service.api.UserService;

/**
 * @author dell
 *
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOG = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserAO findUser(String account) {
		UserExample ue = new UserExample();
		ue.createCriteria().andAccountEqualTo(account);

		List<User> users = userMapper.selectByExample(ue);
		UserAO userAO = new UserAO();

		if (!CollectionUtils.isEmpty(users)) {
			try {
				BeanUtils.copyProperties(userAO, users.get(0));
			} catch (IllegalAccessException e) {
				LOG.error("对象转化错误", e);
			} catch (InvocationTargetException e) {
				LOG.error("对象转化错误", e);
			}
		}

		return userAO;
	}

	@Override
	public List<UserAO> queryUser(UserAO userAO) {

		return null;
	}
}
