package com.yuxy.myblog.web.blog;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuxy.myblog.domain.Article;
import com.yuxy.myblog.domain.Comment;
import com.yuxy.myblog.domain.User;
import com.yuxy.myblog.service.article.ArticleService;
import com.yuxy.myblog.service.comment.CommentService;

/**
  * 查看文章控制器
 * @author Yuxy
 * @version 2019年5月3日 上午9:12:21
 *
 */
@Controller
public class ViewArticleController {
	
	@Autowired
	private ArticleService as;
	
	@Autowired
	private CommentService cs;
	
	/**
	 * 查看具体某个文章的请求
	 * @param articleID 文章ID
	 * @return
	 */
	@RequestMapping("/view-article/{id}")
	public String viewArticle(HttpServletRequest request, @PathVariable("id") String articleId) {
		Article a = as.getArticle(new BigInteger(articleId));
		request.setAttribute("article", a);
		List<Comment> l = cs.getCommentsByArticleID(new BigInteger(articleId));
		request.setAttribute("comment", l);
		return "blog/viewArticle";
	}
	
	@RequestMapping(value = "/submitComment", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitComment(HttpSession session, String articleID, String content) {
		Map<String, Object> m = new HashMap<String, Object>();
		
		User user = (User)session.getAttribute("user");
		if(user == null) {
			m.put("result", -1);
			return m;
		}
		Comment c = new Comment();
		Article a = new Article();
		a.setArticleID(new BigInteger(articleID));
		c.setArticle(a);
		c.setUser(user);
		c.setContent(content);
		if(cs.addComment(c) == 1) {
			m.put("result", 1);
		} else {
			m.put("result", 0);
		}
		return m;
	}
}
