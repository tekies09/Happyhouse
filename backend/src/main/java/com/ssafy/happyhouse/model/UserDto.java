package com.ssafy.happyhouse.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class UserDto {
	private String userName;
	private String userId;
	private String userPwd;
	private String userAddress;
	private String userPhone;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	@Override
	public String toString() {
		return "UserDto [userName=" + userName + ", userId=" + userId + ", userPwd=" + userPwd + ", userAddress="
				+ userAddress + ", userPhone=" + userPhone + "]";
	}


}
