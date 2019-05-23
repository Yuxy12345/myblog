package com.yuxy.myblog.domain;

import java.math.BigInteger;
import java.util.Date;

/**
 * 评论封装类
 * 
 * @author Yuxy
 *
 */
public class Comment {
	private BigInteger CommentID;
	private Article article;
	private User user;
	private Comment replyComment;
	private Date UpdateTime;
	private String Content;

	public BigInteger getCommentID() {
		return CommentID;
	}

	public void setCommentID(BigInteger commentID) {
		CommentID = commentID;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Comment getReplyComment() {
		return replyComment;
	}

	public void setReplyComment(Comment replyComment) {
		this.replyComment = replyComment;
	}

	public Date getUpdateTime() {
		return UpdateTime;
	}

	public void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
