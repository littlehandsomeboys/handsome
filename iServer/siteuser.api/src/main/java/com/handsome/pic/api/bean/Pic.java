package com.handsome.pic.api.bean;

import java.io.Serializable;
import java.util.Date;

public class Pic implements Serializable
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public Pic()
	{
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * id
	 */
	private String picId;
	
	/**
	 * 保存目录
	 */
	private String dir;
	
	/**
	 * 访问地址
	 */
	private String url;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 更新时间
	 */
	private Date updateDate;

	public String getPicId()
	{
		return picId;
	}

	public void setPicId(String picId)
	{
		this.picId = picId;
	}

	public String getDir()
	{
		return dir;
	}

	public void setDir(String dir)
	{
		this.dir = dir;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
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
		return "Pic [picId=" + picId + ", dir=" + dir + ", url=" + url
				+ ", createDate=" + createDate + ", updateDate=" + updateDate
				+ "]";
	}
	
	

}
