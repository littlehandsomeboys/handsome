package com.handsome.common.bean;

import java.io.Serializable;

public class PageInfo implements Serializable
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 默认每页条数
	 */
	public static int DEFAULT_PAGESIZE = 10;

	public PageInfo()
	{
		// TODO Auto-generated constructor stub
		pageSize = DEFAULT_PAGESIZE;
	}

	/**
	 * 总数
	 */
	private int totalRecord;

	/**
	 * 总页数
	 */
	private int totalPage;

	/**
	 * 当前页码
	 */
	private int pageNo;

	/**
	 * 每页行数
	 */
	private int pageSize;

	public int getTotalRecord()
	{
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord)
	{
		this.totalRecord = totalRecord;
	}

	public int getTotalPage()
	{
		return totalPage;
	}

	public void setTotalPage(int totalPage)
	{
		this.totalPage = totalPage;
	}

	public int getPageNo()
	{
		return pageNo;
	}

	public void setPageNo(int pageNo)
	{
		this.pageNo = pageNo;
	}

	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	@Override
	public String toString()
	{
		return "PageInfo [totalRecord=" + totalRecord + ", totalPage="
				+ totalPage + ", pageNo=" + pageNo + ", pageSize=" + pageSize
				+ "]";
	}

}
