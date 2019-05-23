package com.yuxy.myblog.domain;

import java.math.BigInteger;

/**
 * 用户数据封装类
 * 
 * @author Yuxy
 */
public class User {
	private BigInteger UserID;
	private String UserName;
	private String Email;
	private String PassWord;
	private String UserType;

	public BigInteger getUserID() {
		return UserID;
	}

	public void setUserID(BigInteger userID) {
		UserID = userID;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassWord() {
		return PassWord;
	}

	public void setPassWord(String passWord) {
		PassWord = passWord;
	}

	public String getUserType() {
		return UserType;
	}

	public void setUserType(String userType) {
		UserType = userType;
	}

}
