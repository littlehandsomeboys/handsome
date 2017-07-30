package com.handsome.admin.ao.module.classes;

public class ClassAO extends com.handsome.admin.ao.bean.Class {

	private Long point;

	private String campName;
	
	private String campId;
	
	public Long getPoint() {
		return point;
	}

	public void setPoint(Long point) {
		this.point = point;
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
