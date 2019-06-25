package com.yuxy.myblog.service.article;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yuxy.myblog.common.TypeTransferer;
import com.yuxy.myblog.domain.Article;
import com.yuxy.myblog.mapper.ArticleDAO;

/**
 * 文章服务实现
 * 
 * @author Yuxy
 * @version 2019年5月2日 下午12:23:46
 *
 */
@Service
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleDAO ad;

	public List<Article> getAllArticles(int wordNum) {
		List<Article> l = ad.getAllArticles(wordNum);
		return l;
	}

	public Article getArticle(BigInteger articleId) {
		return ad.getArticle(articleId);
	}

	public int addArticle(String title, String content, BigInteger typeID) {
		Article a = new Article(title, content, typeID, new BigInteger("1"));
		
		return ad.addArticle(a);
	}

	public int submitArticle(String title, String content, BigInteger typeID) {
		Article a = new Article(title, content, typeID, new BigInteger("1"), "check");
		
		return ad.addArticle(a);
	}

	public int submitArticle(BigInteger articleID) {
		return ad.submitArticle(articleID);
	}

	public List<Article> getMyArticleList(BigInteger userID) {
		List<Article> l = ad.getMyArticleList(userID);
		for(Article a : l) {
			a.setStatus(new TypeTransferer().toChinese(a.getStatus()));
		}
		return l;
	}

	@Override
	public int deleteArticle(BigInteger articleID) {
		return ad.deleteArticle(articleID);
	}

	@Override
	public List<Article> searchArticle(String searchWord) {
		return ad.searchArticle(searchWord);
	}

	@Override
	public List<Article> getRecentArticle() {
		return ad.getRecentArticle();
	}

}
