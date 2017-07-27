package com.handsome.admin.ao.module.student;

import com.handsome.admin.ao.bean.Student;

public class StudentAO extends Student {

	private Long point;

	private int rowNo;
	
	private String className;
	
	private String topNo;
	
	public Long getPoint() {
		return point;
	}

	public void setPoint(Long point) {
		this.point = point;
	}

	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTopNo() {
		return topNo;
	}

	public void setTopNo(String topNo) {
		this.topNo = topNo;
	}

}
