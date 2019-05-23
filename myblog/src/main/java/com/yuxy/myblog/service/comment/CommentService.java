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
	 * 
	 * @param articleId
	 * @return
	 */
	public List<Comment> getCommentsByArticleID(BigInteger articleId);
	
	/**
	 * 
	 * @param comment
	 * @return
	 */
	public int addComment(Comment comment);
}
