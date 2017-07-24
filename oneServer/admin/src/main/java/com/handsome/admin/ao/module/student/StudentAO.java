package com.handsome.admin.ao.module.student;

import com.handsome.admin.ao.bean.Student;

public class StudentAO extends Student {

	private Long point;

	private int rowNo;
	
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

	
}
