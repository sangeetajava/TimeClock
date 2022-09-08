package com.employee.vo;

import java.sql.Timestamp;

public class ShiftVO {
	private int id;
	private String status;
	private Timestamp startTime;
	private Timestamp endTime;
	private EmployeeVO user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public EmployeeVO getUser() {
		return user;
	}
	public void setUser(EmployeeVO user) {
		this.user = user;
	}
	
}
