package com.yuxy.myblog.service.comment;

import java.math.BigInteger;
import java.util.List;

import com.yuxy.myblog.domain.Comment;

/**
 * 
 * @author Yuxy
 * @version 2019年5月16日 下午3:08:32
 *
 */
public interface CommentService {
	
	/**
	 * 获取指定文章的评论
	 * 
	 * @param articleId
	 * @return
	 */
	public List<Comment> getCommentsByArticleID(BigInteger articleId);
	
	/**
	 * 添加评论
	 * 
	 * @param comment
	 * @return
	 */
	public int addComment(Comment comment);
	
	/**
	 * 获取最近评论
	 * 
	 * @return 
	 */
	public List<Comment> getRecentComment();
}
