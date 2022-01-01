package com.ssafy.happyhouse.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class VueUserDto {
	private String userId;
	private String userPassword;
	private String userName;
	private String userEmail;
	private int userAge;
	private String userSex;
	private String joinTime;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}
	@Override
	public String toString() {
		return "VueUserDto [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", userAge=" + userAge + ", userSex=" + userSex + ", joinTime="
				+ joinTime + "]";
	}

}
