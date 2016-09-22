package com.handsome.siteuser.api.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author dell
 *
 */
public class SiteUser implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 管理员id
	 */
	private String siteUserId;

	/**
	 * 账号
	 */
	private String account;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 权限类型：1 超级管理员 2 企业管理员
	 */
	private String authorities;

	/**
	 * 使能：1 启用 2 禁用
	 */
	private String enabled;

	/**
	 * 归属企业名称，超级管理员为空
	 */
	private String ecName;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 更新时间
	 */
	private Date updateDate;

	public String getSiteUserId()
	{
		return siteUserId;
	}

	public void setSiteUserId(String siteUserId)
	{
		this.siteUserId = siteUserId;
	}

	public String getAccount()
	{
		return account;
	}

	public void setAccount(String account)
	{
		this.account = account;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getAuthorities()
	{
		return authorities;
	}

	public void setAuthorities(String authorities)
	{
		this.authorities = authorities;
	}

	public String getEnabled()
	{
		return enabled;
	}

	public void setEnabled(String enabled)
	{
		this.enabled = enabled;
	}

	public String getEcName()
	{
		return ecName;
	}

	public void setEcName(String ecName)
	{
		this.ecName = ecName;
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	public Date getUpdateDate()
	{
		return updateDate;
	}

	public void setUpdateDate(Date updateDate)
	{
		this.updateDate = updateDate;
	}

	@Override
	public String toString()
	{
		return "SiteUser [siteUserId=" + siteUserId + ", account=" + account
				+ ", password=" + password + ", authorities=" + authorities
				+ ", enabled=" + enabled + ", ecName=" + ecName
				+ ", createDate=" + createDate + ", updateDate=" + updateDate
				+ "]";
	}

}
