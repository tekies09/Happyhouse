package com.ssafy.happyhouse.model;

public class VueChartDto {
	private String userColumn;
	private String userCount;
	public String getUserColumn() {
		return userColumn;
	}
	public void setUserColumn(String userColumn) {
		this.userColumn = userColumn;
	}
	public String getUserCount() {
		return userCount;
	}
	public void setUserCount(String userCount) {
		this.userCount = userCount;
	}
	@Override
	public String toString() {
		return "VueChartDto [userColumn=" + userColumn + ", userCount=" + userCount + "]";
	}
}
