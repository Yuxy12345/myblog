package com.yuxy.myblog.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuxy.myblog.domain.Article;
import com.yuxy.myblog.domain.Comment;
import com.yuxy.myblog.service.article.ArticleService;
import com.yuxy.myblog.service.comment.CommentService;
import com.yuxy.myblog.web.common.CommonController;

/**
 * 后台管理控制器
 * @author Yuxy
 * @version 2019年5月5日 下午3:28:58
 *
 */
@Controller
public class AdminController extends CommonController {
	
	@Autowired
	ArticleService as;
	
	@Autowired
	CommentService cs;
	/**
	 * 后台管理入口请求
	 * 
	 * @return
	 */
	@RequestMapping("/admin")
	public String admin(HttpServletRequest request) {
		List<Article> la = as.getRecentArticle();
		request.setAttribute("articles", la);
		List<Comment> lc = cs.getRecentComment();
		request.setAttribute("comments", lc);
		return "admin/overview";
	}
}
