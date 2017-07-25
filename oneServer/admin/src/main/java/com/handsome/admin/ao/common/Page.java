package com.handsome.admin.ao.common;

public class Page {

	/**
	 * 当前页码
	 */
	private int pageNo;
	
	/**
	 * 每页长度
	 */
	private int length;

	private int begin;
	private int end;
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getBegin() {
		begin = (pageNo-1) * length;
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		end = ((pageNo-1) * length) + length;
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
}
