package com.handsome.admin.ao.module.student;

import com.handsome.admin.ao.bean.Student;

public class StudentAO extends Student {

	private Long point;

	private int rowNo;
	
	private String className;
	
	private String topNo;
	
	private String titleId;
	
	private String titleName;
	
	private String campId;
	
	private String campName;
	
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

	public String getTitleId() {
		return titleId;
	}

	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getCampName() {
		return campName;
	}

	public void setCampName(String campName) {
		this.campName = campName;
	}

	public String getCampId() {
		return campId;
	}

	public void setCampId(String campId) {
		this.campId = campId;
	}

}
