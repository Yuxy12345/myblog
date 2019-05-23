package com.yuxy.myblog.service.comment;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yuxy.myblog.domain.Comment;
import com.yuxy.myblog.mapper.CommentDAO;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Resource
	CommentDAO cd;

	@Override
	public List<Comment> getCommentsByArticleID(BigInteger articleId) {
		return cd.getCommentsByArticleID(articleId);
	}

	@Override
	public int addComment(Comment comment) {
		return cd.addComment(comment);
	}
}
