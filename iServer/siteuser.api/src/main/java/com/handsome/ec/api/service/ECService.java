package com.handsome.ec.api.service;

import java.util.List;

import com.handsome.common.bean.PageInfo;
import com.handsome.ec.api.bean.EC;

/**
 * 
 * @author dell
 *
 */
public interface ECService
{

	/**
	 * 添加企业
	 * @param ec
	 */
	void createEC(EC ec);

	/**
	 * 修改企业
	 * @param ec
	 */
	void updateEC(EC ec);
	
	/**
	 * 根据Id查询企业
	 * 
	 * @param ecId
	 * @return
	 */
	EC getECById(String ecId);

	/**
	 * 根据用户名查询用户
	 * 
	 * @param ecName
	 * @return
	 */
	EC getECByECName(String ecName);

	/**
	 * 查询企业列表  支持分页 PageInfo为空时查询所有
	 * @param ec
	 * @param pi
	 * @return
	 */
	List<EC> getECList(EC ec, PageInfo pi);
	
	/**
	 * 企业总数
	 * @return
	 */
	int countEC();
	
	/**
	 * 根据Id删除企业
	 * 
	 * @param ecId
	 * @return
	 */
	int deleteEC(String ecId);
	
}
