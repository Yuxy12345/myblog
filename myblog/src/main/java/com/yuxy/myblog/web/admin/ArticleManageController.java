package com.yuxy.myblog.web.admin;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuxy.myblog.common.LoginCheck;
import com.yuxy.myblog.domain.Article;
import com.yuxy.myblog.domain.Type;
import com.yuxy.myblog.domain.User;
import com.yuxy.myblog.service.article.ArticleService;
import com.yuxy.myblog.service.type.TypeService;
import com.yuxy.myblog.web.common.CommonController;

/**
 * 编辑文章控制器
 * 
 * @author Yuxy
 * @version 2019年5月5日 下午3:38:24
 *
 */
@Controller
public class ArticleManageController extends CommonController {

	@Autowired
	ArticleService as;

	@Autowired
	TypeService ts;

	@RequestMapping("/admin/article")
	public String articleManage(HttpSession session, HttpServletRequest request) {
		User user = (User) session.getAttribute("user");

		List<Article> l;
		if (user != null) {
			l = as.getMyArticleList(user.getUserID());
		} else {
			l = as.getAllArticles(1);
		}
		request.setAttribute("article", l);

		return "admin/articleManage";
	}

	@RequestMapping("/admin/articleEdit")
	public String articleEdit(HttpServletRequest request) {
		List<Type> l = ts.getAllTypes();
		request.setAttribute("typeList", l);
		return "admin/articleEdit";
	}

	@RequestMapping("/admin/articleModify/{id}")
	public String articleModify(HttpServletRequest request, @PathVariable("id") BigInteger articleId) {
		Article a = as.getArticle(articleId);
		request.setAttribute("article", a);

		List<Type> l = ts.getAllTypes();
		request.setAttribute("typeList", l);

		return "admin/articleModify";
	}

	@RequestMapping(value = "/admin/articleDelete/{id}")
	@ResponseBody
	public Map<String, Object> deleteArticle(HttpSession session, @PathVariable BigInteger articleID) {
		Map<String, Object> m = new HashMap<>();
		if (new LoginCheck(session).isLogin()) {
			int res = as.deleteArticle(articleID);
			if (res == 1) {
				m.put("result", 1);
			} else {
				m.put("result", 0);
			}
		} else {
			m.put("result", -1);
		}

		return m;
	}

	@RequestMapping(value = "/admin/{dowhat}Article", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addArticle(@RequestParam("title") String title, @RequestParam("content") String content,
			@RequestParam("type") BigInteger typeID, @PathVariable(name = "dowhat") String dowhat) {

		Map<String, Object> m = new HashMap<String, Object>();
		int res;
		if (dowhat.equals("add")) {
			res = as.addArticle(title, content, typeID);
		} else {
			res = as.submitArticle(title, content, typeID);
		}

		if (res == 1) {
			m.put("result", 1);
		}
		return m;
	}

}
