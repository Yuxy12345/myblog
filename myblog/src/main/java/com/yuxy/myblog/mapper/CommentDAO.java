package com.yuxy.myblog.mapper;

import java.math.BigInteger;
import java.util.List;

import com.yuxy.myblog.domain.Comment;

/**
 * 文章评论DAO接口
 * 
 * @author Yuxy
 * @version 2019年5月16日 下午3:05:27
 *
 */
public interface CommentDAO {
	
	/**
	 * 获取指定文章的所有评论
	 * 
	 * @param articleId
	 * @return
	 */
	public List<Comment> getCommentsByArticleID(BigInteger articleId);
	/**
	 * 获取所有评论
	 * 
	 * @return 所有评论列表
	 */
	public List<Comment> getAllComment();
	
	/**
	 * 添加评论
	 * 
	 * @param comment 评论实体对象
	 * @return 1成功
	 */
	public int addComment(Comment comment);
	
	/**
	 * 获取最近评论
	 * 
	 * @return 
	 */
	public List<Comment> getRecentComment();
	
}
