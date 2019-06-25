package com.yuxy.myblog.web.blog;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yuxy.myblog.domain.Article;
import com.yuxy.myblog.service.article.ArticleService;
import com.yuxy.myblog.web.common.CommonController;

/**
 *  导航栏控制器
 *  
 * @author Yuxy
 * @version 2019年5月3日 上午9:13:09
 *
 */
@Controller
@SessionAttributes(value = "setting")
public class NavBarController extends CommonController {
	
	@Autowired
	private ArticleService as;
	
	/**
	 * 浏览主页请求
	 */
	@RequestMapping("/home")
	public String home(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		List<Article> l = as.getAllArticles(50);
		setSiteName(session);
		request.setAttribute("Article", l);
		return "blog/homePage";
	}
	
	/**
	 * 浏览所有文章请求
	 */
	@RequestMapping("/all_articles")
	public String allArticles(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		List<Article> l = as.getAllArticles(50);
		setSiteName(session);
		request.setAttribute("Article", l);
		return "blog/articleList";
	}
	
	@RequestMapping("/search")
	public String searchArticles(HttpServletRequest request, @RequestParam("searchWord") String searchWord) {
		List<Article> l = as.searchArticle(searchWord);
		request.setAttribute("searchWord", searchWord);
		request.setAttribute("Article", l);
		return "blog/searchResult";
	}
}
