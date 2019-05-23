package com.yuxy.myblog.domain;

import java.math.BigInteger;
import java.util.Date;

/**
 * 文章数据封装类
 * 
 * @author Yuxy
 * 
 */
public class Article {
	private BigInteger ArticleID;
	private String Title;
	private Date UpdateTime;
	private String Status;
	private String Content;
	private String Abbr;
	private Type type;
	private User user;

	public Article() {
		
	}
	
	public Article(String title, String content, BigInteger typeID, BigInteger userID) {
		Title = title;
		Content = content;
		Abbr = "test";
		Status = "edit";
		type = new Type();
		type.setTypeID(typeID);
		user = new User();
		user.setUserID(userID);
	}
	
	public Article(String title, String content, BigInteger typeID, BigInteger userID, String status) {
		Title = title;
		Content = content;
		Abbr = "test";
		Status = status;
		type = new Type();
		type.setTypeID(typeID);
		user = new User();
		user.setUserID(userID);
	}
	
	// TODO 添加完整的构造方法
	
	public BigInteger getArticleID() {
		return ArticleID;
	}

	public void setArticleID(BigInteger articleID) {
		ArticleID = articleID;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Date getUpdateTime() {
		return UpdateTime;
	}

	public void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getAbbr() {
		return Abbr;
	}

	public void setAbbr(String abbr) {
		Abbr = abbr;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
