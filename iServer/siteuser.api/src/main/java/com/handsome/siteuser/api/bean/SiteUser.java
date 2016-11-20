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
	 * 权限类型：1 超级管理员 2 企业管理员 3部门管理员
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
	 * 预留属性
	 */
	private String reserve0;
	
	/**
	 * 预留属性
	 */
	private String reserve1;
	
	/**
	 * 预留属性
	 */
	private String reserve2;
	
	/**
	 * 预留属性
	 */
	private String reserve3;
	
	/**
	 * 预留属性
	 */
	private String reserve4;
	
	/**
	 * 预留属性
	 */
	private String reserve5;
	
	/**
	 * 预留属性
	 */
	private String reserve6;
	
	/**
	 * 预留属性
	 */
	private String reserve7;
	
	/**
	 * 预留属性
	 */
	private String reserve8;
	
	/**
	 * 预留属性
	 */
	private String reserve9;
	
	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 更新时间
	 */
	private Date updateDate;
	
	/**
	 * 图片
	 */
	private String picUrl;
	
	/**
	 * 头像
	 */
	private String headUrl;
	

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

	public String getReserve0()
	{
		return reserve0;
	}

	public void setReserve0(String reserve0)
	{
		this.reserve0 = reserve0;
	}

	public String getReserve1()
	{
		return reserve1;
	}

	public void setReserve1(String reserve1)
	{
		this.reserve1 = reserve1;
	}

	public String getReserve2()
	{
		return reserve2;
	}

	public void setReserve2(String reserve2)
	{
		this.reserve2 = reserve2;
	}

	public String getReserve3()
	{
		return reserve3;
	}

	public void setReserve3(String reserve3)
	{
		this.reserve3 = reserve3;
	}

	public String getReserve4()
	{
		return reserve4;
	}

	public void setReserve4(String reserve4)
	{
		this.reserve4 = reserve4;
	}

	public String getReserve5()
	{
		return reserve5;
	}

	public void setReserve5(String reserve5)
	{
		this.reserve5 = reserve5;
	}

	public String getReserve6()
	{
		return reserve6;
	}

	public void setReserve6(String reserve6)
	{
		this.reserve6 = reserve6;
	}

	public String getReserve7()
	{
		return reserve7;
	}

	public void setReserve7(String reserve7)
	{
		this.reserve7 = reserve7;
	}

	public String getReserve8()
	{
		return reserve8;
	}

	public void setReserve8(String reserve8)
	{
		this.reserve8 = reserve8;
	}

	public String getReserve9()
	{
		return reserve9;
	}

	public void setReserve9(String reserve9)
	{
		this.reserve9 = reserve9;
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

	public String getPicUrl()
	{
		return picUrl;
	}

	public void setPicUrl(String picUrl)
	{
		this.picUrl = picUrl;
	}

	public String getHeadUrl()
	{
		return headUrl;
	}

	public void setHeadUrl(String headUrl)
	{
		this.headUrl = headUrl;
	}

	@Override
	public String toString()
	{
		return "SiteUser [siteUserId=" + siteUserId + ", account=" + account
				+ ", password=" + password + ", authorities=" + authorities
				+ ", enabled=" + enabled + ", ecName=" + ecName + ", reserve0="
				+ reserve0 + ", reserve1=" + reserve1 + ", reserve2="
				+ reserve2 + ", reserve3=" + reserve3 + ", reserve4="
				+ reserve4 + ", reserve5=" + reserve5 + ", reserve6="
				+ reserve6 + ", reserve7=" + reserve7 + ", reserve8="
				+ reserve8 + ", reserve9=" + reserve9 + ", createDate="
				+ createDate + ", updateDate=" + updateDate + ", picUrl="
				+ picUrl + ", headUrl=" + headUrl + "]";
	}

}
