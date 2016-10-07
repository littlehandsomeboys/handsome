package com.handsome.ec.api.bean;

import java.io.Serializable;
import java.util.Date;

public class EC implements Serializable
{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 企业id
	 */
	private String ecId;
	
	/**
	 * 企业名称
	 */
	private String ecName;
	
	/**
	 * 企业描述
	 */
	private String desc;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 更新时间
	 */
	private Date updateDate;

	public String getEcId()
	{
		return ecId;
	}

	public void setEcId(String ecId)
	{
		this.ecId = ecId;
	}

	public String getEcName()
	{
		return ecName;
	}

	public void setEcName(String ecName)
	{
		this.ecName = ecName;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
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
		return "EC [ecId=" + ecId + ", ecName=" + ecName + ", desc=" + desc
				+ ", createDate=" + createDate + ", updateDate=" + updateDate
				+ "]";
	}
	
	
}
